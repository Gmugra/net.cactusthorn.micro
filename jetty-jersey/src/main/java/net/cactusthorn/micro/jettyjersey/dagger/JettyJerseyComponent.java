package net.cactusthorn.micro.jettyjersey.dagger;

import net.cactusthorn.micro.core.banner.Banner;

import net.cactusthorn.micro.jettyjersey.rest.JerseyResourceConfig;
import net.cactusthorn.micro.jettyjersey.rest.dagger.RestModule;

import dagger.*;
import javax.inject.*;

import org.flywaydb.core.Flyway;

@Component(modules = { RestModule.class })
@Singleton
public interface JettyJerseyComponent {

    Banner banner();

    Flyway flyway();

    JerseyResourceConfig resourceConfig();
}
