package net.cactusthorn.micro.core.dagger.entrypoint;

import java.util.Map;

import javax.inject.Provider;

public interface EntryPointComponent {

    Map<Class<?>, Provider<EntryPoint>> entryPoints();
}
