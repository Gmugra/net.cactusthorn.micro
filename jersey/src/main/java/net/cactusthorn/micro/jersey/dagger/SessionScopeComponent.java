package net.cactusthorn.micro.jersey.dagger;

import java.util.Map;

import javax.inject.Provider;
import dagger.Subcomponent;

import net.cactusthorn.micro.core.dagger.*;
import net.cactusthorn.micro.core.dagger.entrypoint.*;

@SessionScope @Subcomponent(modules = { SessionScopeModule.class }) //
public interface SessionScopeComponent extends EntryPointComponent {

    @Override @NamedScope(SessionScope.class) //
    Map<Class<?>, Provider<EntryPoint>> entryPoints();

    @Subcomponent.Builder //
    interface Builder extends EntryPointComponentBuilder<SessionScopeComponent> {
        SessionScopeComponent build();
    }
}
