package net.cactusthorn.micro.jersey.dagger;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;
import net.cactusthorn.micro.core.dagger.entrypoint.*;
import net.cactusthorn.micro.db.jooq.dagger.JooqModule;

@Singleton @Component(modules = { SessionScopeBuilderModule.class, RequestScopeModule.class, JooqModule.class }) //
public interface JerseyComponent extends ApplicationComponent {

    @Override //
    public Map<Class<?>, Provider<EntryPoint>> requestScopeEntryPoints();

    @Override @SuppressWarnings("rawtypes") //
    public EntryPointComponentBuilder sessionScopeComponentBuilder();
}
