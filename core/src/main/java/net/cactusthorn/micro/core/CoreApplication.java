package net.cactusthorn.micro.core;

import net.cactusthorn.micro.core.dagger.CoreComponent;
import net.cactusthorn.micro.core.dagger.DaggerCoreComponent;

public class CoreApplication {

    public static void main(String... args) throws Exception {

        CoreComponent component = DaggerCoreComponent.create();

        component.banner().show();
    }
}
