package net.cactusthorn.micro.jersey;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.core.dagger.entrypoint.ApplicationComponent;

public class JerseyServletContextListner implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(JerseyServletContextListner.class);

    private ApplicationComponent component;

    public JerseyServletContextListner(ApplicationComponent component) {
        this.component = component;
    }

    @Override //
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(ApplicationComponent.class.getName(), component);
        LOG.info("contextInitialized!");
    }

    @Override //
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("contextDestroyed!");
    }

}
