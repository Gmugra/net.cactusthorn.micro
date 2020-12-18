package net.cactusthorn.micro.jersey.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;
import net.cactusthorn.micro.jersey.rest.TestRest;
import net.cactusthorn.micro.jersey.rest.TestRest2;

@Module //
public abstract class RequestScopeModule {

    @Binds @IntoMap @ClassKey(TestRest.class) //
    public abstract EntryPoint bindTestRest(TestRest entryPoint);

    @Binds @IntoMap @ClassKey(TestRest2.class) //
    public abstract EntryPoint bindTestRest2(TestRest2 entryPoint);
}
