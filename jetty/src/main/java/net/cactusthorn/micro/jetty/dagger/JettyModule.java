package net.cactusthorn.micro.jetty.dagger;

import net.cactusthorn.micro.jersey.dagger.JerseyModule;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import dagger.Module;
import dagger.Provides;

@Module(includes = JerseyModule.class)
public class JettyModule {

    @Provides
    public static ServletContextHandler provideJerseyServletContextHandler(ServletContainer jerseyServletContainer) {
        ServletHolder servletHolder = new ServletHolder(jerseyServletContainer);
        servletHolder.setInitOrder(0);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletContext.setContextPath("/");
        servletContext.addServlet(servletHolder, "/rest/*");

        return servletContext;
    }
}
