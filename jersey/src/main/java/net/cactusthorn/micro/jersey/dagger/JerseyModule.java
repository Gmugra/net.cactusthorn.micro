package net.cactusthorn.micro.jersey.dagger;

import org.glassfish.jersey.servlet.ServletContainer;

import dagger.*;
import dagger.multibindings.*;

import net.cactusthorn.micro.db.jooq.dagger.JooqModule;

import net.cactusthorn.micro.jersey.JerseyResourceConfig;

import net.cactusthorn.micro.jersey.rest.*;

@Module(includes = JooqModule.class)
public abstract class JerseyModule {

    @Provides
    public static ServletContainer provideServletContainer(JerseyResourceConfig resourceConfig ) {
        return new ServletContainer(resourceConfig);
    }

    @IntoMap
    @ClassKey(TestRest.class)
    @Binds
    public abstract EntryPoint bindTestRest(TestRest testRest);

    @IntoMap
    @ClassKey(TestRest2.class)
    @Binds
    public abstract EntryPoint bindTestRest2(TestRest2 testRest2);
}
