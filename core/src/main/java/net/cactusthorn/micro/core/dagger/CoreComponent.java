package net.cactusthorn.micro.core.dagger;

import javax.inject.Singleton;
import dagger.Component;

import net.cactusthorn.micro.core.banner.Banner;

@Component(modules = { CoreModule.class })
@Singleton
public interface CoreComponent {

    public Banner banner();
}
