package net.cactusthorn.micro.core.dagger;

import dagger.*;
import net.cactusthorn.micro.core.configuration.*;
import net.cactusthorn.micro.core.configuration.owner.loader.*;

import javax.inject.Singleton;

import org.aeonbits.owner.*;

@Module //
public class CoreModule {

    @Provides @Singleton //
    public static Factory provideConfigFactory() {
        Factory factory = ConfigFactory.newInstance();
        factory.registerLoader(new JarManifest());
        return factory;
    }

    @Provides @Singleton //
    public static AppInfo provideAppConfig(Factory factory) {
        return factory.create(AppInfo.class);
    }

}
