package net.cactusthorn.micro.core.dagger.entrypoint;

import java.util.Map;

import javax.inject.Provider;

public interface ApplicationComponent {

    Map<Class<?>, Provider<EntryPoint>> requestScopeEntryPoints();

    @SuppressWarnings("rawtypes") //
    EntryPointComponentBuilder sessionScopeComponentBuilder();
}
