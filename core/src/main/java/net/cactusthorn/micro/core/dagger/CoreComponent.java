package net.cactusthorn.micro.core.dagger;

import javax.inject.Singleton;
import dagger.Component;

import net.cactusthorn.micro.core.banner.Banner;
import net.cactusthorn.micro.core.configuration.AppInfo;

@Component(modules = { CoreModule.class })
@Singleton
public interface CoreComponent {

    Banner banner();

    AppInfo appInfo();
}
