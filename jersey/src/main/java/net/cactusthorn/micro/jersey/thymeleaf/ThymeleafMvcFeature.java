package net.cactusthorn.micro.jersey.thymeleaf;

import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import org.glassfish.jersey.server.mvc.MvcFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThymeleafMvcFeature implements Feature {

    private static final Logger LOG = LoggerFactory.getLogger(ThymeleafMvcFeature.class);

    @Override //
    public boolean configure(FeatureContext context) {

        final Configuration config = context.getConfiguration();

        if (!config.isRegistered(ThymeleafViewProcessor.class)) {

            // Template Processor.
            context.register(ThymeleafViewProcessor.class);

            // MvcFeature.
            if (!config.isRegistered(MvcFeature.class)) {
                context.register(MvcFeature.class);
                LOG.info("MVC REGISTERED!");
            }

            LOG.info("Thymeleaf REGISTERED!");

            return true;
        }
        return false;
    }

}
