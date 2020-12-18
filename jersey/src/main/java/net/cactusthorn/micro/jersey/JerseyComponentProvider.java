package net.cactusthorn.micro.jersey;

import java.util.*;
import java.util.function.Supplier;

import org.glassfish.jersey.internal.inject.*;
import org.glassfish.jersey.server.spi.ComponentProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.core.dagger.entrypoint.*;

import javax.inject.Provider;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class JerseyComponentProvider implements ComponentProvider {

    private static final Logger LOG = LoggerFactory.getLogger(JerseyComponentProvider.class);

    private volatile InjectionManager injectionManager;

    private volatile Map<Class<?>, Provider<EntryPoint>> requestScopeEntryPoints;
    private volatile Set<Class<?>> sessionScopeClasses;
    private volatile ApplicationComponent appComponent;

    @Override //
    public void initialize(InjectionManager injectionManager) {

        this.injectionManager = injectionManager;

        ServletContext servletContext = injectionManager.getInstance(ServletContext.class);
        appComponent = (ApplicationComponent) servletContext.getAttribute(ApplicationComponent.class.getName());

        requestScopeEntryPoints = appComponent.requestScopeEntryPoints();

        sessionScopeClasses = appComponent.sessionScopeComponentBuilder().build().entryPoints().keySet();

        LOG.info("INITIALIZED!");
    }

    @Override //
    public boolean bind(Class<?> component, Set<Class<?>> providerContracts) {
        if (requestScopeEntryPoints.keySet().contains(component)) {

            Binding<Supplier<EntryPoint>, SupplierInstanceBinding<EntryPoint>> binding = Bindings
                    .supplier(new RequestScopeSupplier(requestScopeEntryPoints.get(component))).to(component);

            injectionManager.register(binding);

            LOG.info("BIND (RequestScope): {}", component);
            return true;
        }
        if (sessionScopeClasses.contains(component)) {

            Binding<Supplier<EntryPoint>, SupplierInstanceBinding<EntryPoint>> binding = Bindings
                    .supplier(new SessionScopeSupplier(component)).to(component);

            injectionManager.register(binding);

            LOG.info("BIND (SessionScope): {}", component);
            return true;
        }
        return false;
    }

    @Override //
    public void done() {

        // not need it anymore, lets inform GC about.
        sessionScopeClasses = null;
        LOG.info("DONE!");
    }

    private class SessionScopeSupplier implements Supplier<EntryPoint> {

        private Class<?> clazz;

        private SessionScopeSupplier(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override //
        public EntryPoint get() {

            EntryPointComponent component;
            HttpServletRequest request = injectionManager.getInstance(HttpServletRequest.class);
            if (request.getSession(false) == null) {

                HttpSession session = request.getSession(true);
                component = appComponent.sessionScopeComponentBuilder().build();
                session.setAttribute(EntryPointComponent.class.getName(), component);
            } else {
                component = (EntryPointComponent) request.getSession(false).getAttribute(EntryPointComponent.class.getName());
            }

            return component.entryPoints().get(clazz).get();
        }

    }

    private class RequestScopeSupplier implements Supplier<EntryPoint> {

        private Provider<EntryPoint> entryPoint;

        private RequestScopeSupplier(Provider<EntryPoint> entryPoint) {
            this.entryPoint = entryPoint;
        }

        @Override //
        public EntryPoint get() {
            return entryPoint.get();
        }

    }

}
