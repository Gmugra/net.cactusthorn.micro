package net.cactusthorn.micro.core.dagger.entrypoint;

public interface EntryPointComponentBuilder<T extends EntryPointComponent> {

    T build();
}
