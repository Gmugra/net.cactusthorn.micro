package net.cactusthorn.micro.core.dagger;

import net.cactusthorn.micro.core.configuration.*;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import net.cactusthorn.config.core.factory.ConfigFactory;

@Module //
public class CoreModule {

    private static final String CONFIG_FILE_NAME = "micro.toml";

    @Provides @Singleton //
    public static ConfigFactory provideConfigFactory() {
        // @formatter:off
        return ConfigFactory.builder()
                .addSource("file:/{micro-config-path}/" + CONFIG_FILE_NAME)
                .addSource("file:./" + CONFIG_FILE_NAME)
                .addSource("classpath:" + CONFIG_FILE_NAME)
                .build();
        // @formatter:on
    }

    @Provides @Singleton //
    public static AppInfo provideAppConfig(ConfigFactory factory) {
        return factory.create(AppInfo.class);
    }

}
