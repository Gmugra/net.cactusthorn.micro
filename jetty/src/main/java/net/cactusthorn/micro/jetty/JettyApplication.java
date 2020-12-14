package net.cactusthorn.micro.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.jetty.dagger.*;

public class JettyApplication {

    private static final Logger LOG = LoggerFactory.getLogger(JettyApplication.class);

    public static void main(String... args) {

        JettyComponent component = DaggerJettyComponent.create();

        component.banner().show();

        component.flyway().migrate();

        ServletContextHandler servletContext = component.jerseyServletContextHandler();

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
}
