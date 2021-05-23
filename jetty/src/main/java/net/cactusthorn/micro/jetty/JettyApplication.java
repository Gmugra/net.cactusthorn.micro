package net.cactusthorn.micro.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.core.dagger.entrypoint.ApplicationComponent;
import net.cactusthorn.micro.jersey.JerseyResourceConfig;
import net.cactusthorn.micro.jersey.JerseyServletContextListner;
import net.cactusthorn.micro.jetty.dagger.*;

public class JettyApplication {

    private static final Logger LOG = LoggerFactory.getLogger(JettyApplication.class);

    public static void main(String... args) {

        // java.util.logging -> SLF4j
        org.slf4j.bridge.SLF4JBridgeHandler.removeHandlersForRootLogger();
        org.slf4j.bridge.SLF4JBridgeHandler.install();
        java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.FINEST);

        JettyComponent component = DaggerJettyComponent.create();

        component.banner().show();

        component.flyway().migrate();

        ServletContextHandler servletContext = servletContextHandler(component);

        Server jetty = new Server(8080);
        jetty.setStopAtShutdown(true);
        jetty.setHandler(servletContext);

        try {
            jetty.start();
            jetty.join();
        } catch (Exception e) {
            LOG.error("", e);
        } finally {
            jetty.destroy();
        }
    }

    public static ServletContextHandler servletContextHandler(ApplicationComponent applicationComponent) {

        JerseyResourceConfig resourceConfig = new JerseyResourceConfig(applicationComponent);

        ServletContainer jerseyServletContainer = new ServletContainer(resourceConfig);
        ServletHolder servletHolder = new ServletHolder(jerseyServletContainer);
        servletHolder.setInitOrder(0);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.addEventListener(new JerseyServletContextListner(applicationComponent));
        servletContext.setContextPath("/");
        servletContext.addServlet(servletHolder, "/rest/*");

        return servletContext;
    }
}
