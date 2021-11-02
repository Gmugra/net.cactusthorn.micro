package net.cactusthorn.micro.jersey.dagger;

import dagger.Binds;
import dagger.Module;
import net.cactusthorn.micro.core.dagger.entrypoint.*;

@Module(subcomponents = { SessionScopeComponent.class }) //
public abstract class SessionScopeBuilderModule {

    @Binds @SuppressWarnings("rawtypes") //
    public abstract EntryPointComponentBuilder bindSessionScopeComponentBuilder(SessionScopeComponent.Builder builder);
}
