package net.cactusthorn.micro.jetty.dagger;

import net.cactusthorn.micro.core.banner.Banner;

import dagger.*;
import javax.inject.*;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.flywaydb.core.Flyway;

@Component(modules = { JettyModule.class })
@Singleton
public interface JettyComponent {

    Banner banner();

    Flyway flyway();

    ServletContextHandler jerseyServletContextHandler();
}
