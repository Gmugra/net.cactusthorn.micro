package net.cactusthorn.micro.jettyjersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.glassfish.jersey.servlet.ServletContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.jettyjersey.dagger.DaggerJettyJerseyComponent;
import net.cactusthorn.micro.jettyjersey.dagger.JettyJerseyComponent;

public class JettyJerseyApplication {

    private static final Logger LOG = LoggerFactory.getLogger(JettyJerseyApplication.class);

    public static void main(String... args) {

        JettyJerseyComponent component = DaggerJettyJerseyComponent.create();

        component.banner().show();

        component.flyway().migrate();

        ServletContextHandler servletContext = createServletContext(component);

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

    private static ServletContextHandler createServletContext(JettyJerseyComponent component) {

        ServletContainer servletContainer = new ServletContainer(component.resourceConfig());

        ServletHolder servletHolder = new ServletHolder(servletContainer);
        servletHolder.setInitOrder(0);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletContext.setContextPath("/");
        servletContext.addServlet(servletHolder, "/rest/*");

        return servletContext;
    }
}
