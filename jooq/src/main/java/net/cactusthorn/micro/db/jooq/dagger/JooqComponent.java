package net.cactusthorn.micro.db.jooq.dagger;

import net.cactusthorn.micro.core.banner.Banner;
import net.cactusthorn.micro.db.jooq.service.TestService;

import org.flywaydb.core.Flyway;

import dagger.Component;
import javax.inject.Singleton;

@Component(modules = { JooqModule.class }) @Singleton //
public interface JooqComponent {

    Banner banner();

    Flyway flyway();

    TestService testService();
}
