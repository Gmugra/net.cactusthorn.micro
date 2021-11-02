package net.cactusthorn.micro.jersey.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.*;
import net.cactusthorn.micro.core.dagger.*;
import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;
import net.cactusthorn.micro.jersey.rest.TestSessionScope;

@Module //
public abstract class SessionScopeModule {

    @Binds @IntoMap @NamedScope(SessionScope.class) @ClassKey(TestSessionScope.class) //
    public abstract EntryPoint bindTestSessionScope(TestSessionScope entryPoint);
}
