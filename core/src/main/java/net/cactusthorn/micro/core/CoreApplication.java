package net.cactusthorn.micro.core;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.core.dagger.CoreComponent;
import net.cactusthorn.micro.core.dagger.DaggerCoreComponent;

public class CoreApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CoreApplication.class);

    public static void main(String... args) throws Exception {

        CoreComponent component = DaggerCoreComponent.create();

        component.banner().show();

        LOG.info("Class-Path:\n{}", component.appInfo().classPath().stream().collect(Collectors.joining("\n")));
    }
}
