package net.cactusthorn.micro.jettyjersey.rest.dagger;

import dagger.*;
import dagger.multibindings.*;

import net.cactusthorn.micro.db.jooq.dagger.JooqModule;

import net.cactusthorn.micro.jettyjersey.rest.*;

@Module(includes = JooqModule.class)
public abstract class RestModule {

    @IntoMap
    @ClassKey(TestRest.class)
    @Binds
    public abstract EntryPoint bindTestRest(TestRest testRest);

    @IntoMap
    @ClassKey(TestRest2.class)
    @Binds
    public abstract EntryPoint bindTestRest2(TestRest2 testRest2);
}
