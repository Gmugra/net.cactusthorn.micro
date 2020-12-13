package net.cactusthorn.micro.jettyjersey.rest;

import java.util.Map;

import javax.inject.*;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JerseyResourceConfig extends ResourceConfig {

    private static Map<Class<?>, Provider<EntryPoint>> entryPoints;

    @Inject
    public JerseyResourceConfig(Map<Class<?>, Provider<EntryPoint>> entryPoints) {

        JerseyResourceConfig.entryPoints = entryPoints;

        for (Class<?> clazz : entryPoints.keySet()) {
            register(clazz);
        }
        register(EntryPointBilder.class);
    }

    private static class EntryPointBilder extends AbstractBinder {

        private static final Logger LOG = LoggerFactory.getLogger(EntryPointBilder.class);

        @Override
        protected void configure() {
            for (Class<?> clazz : entryPoints.keySet()) {
                bindFactory(new EntryPointFactory(clazz)).to(clazz);
                LOG.info("binded: {}", clazz);
            }
        }

    }

    private static class EntryPointFactory implements Factory<EntryPoint> {

        private Class<?> entryPointClass;

        private EntryPointFactory(Class<?> entryPointClass) {
            this.entryPointClass = entryPointClass;
        }

        @Override
        public EntryPoint provide() {
            return entryPoints.get(entryPointClass).get();
        }

        @Override
        public void dispose(EntryPoint entryPoint) {
        }
    }

}
