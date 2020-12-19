package net.cactusthorn.micro.jersey;

import java.util.Map;

import javax.inject.*;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.core.dagger.entrypoint.ApplicationComponent;
import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;
import net.cactusthorn.micro.jersey.thymeleaf.ThymeleafMvcFeature;

public class JerseyResourceConfig extends ResourceConfig {

    private static final Logger LOG = LoggerFactory.getLogger(JerseyResourceConfig.class);

    public JerseyResourceConfig(ApplicationComponent applicationComponent) {

        register(applicationComponent.requestScopeEntryPoints());
        register(applicationComponent.sessionScopeComponentBuilder().build().entryPoints());

        register(ThymeleafMvcFeature.class);
    }

    private void register(Map<Class<?>, Provider<EntryPoint>> entryPoints) {
        for (Class<?> clazz : entryPoints.keySet()) {
            register(clazz);
            LOG.info("REGISTERED: {}", clazz.getName());
        }
    }

}
