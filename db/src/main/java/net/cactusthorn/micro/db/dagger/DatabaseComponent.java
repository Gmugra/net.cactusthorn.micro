package net.cactusthorn.micro.db.dagger;

import net.cactusthorn.micro.core.banner.Banner;
import net.cactusthorn.micro.db.configuration.HikariConf;

import com.zaxxer.hikari.HikariDataSource;

import org.flywaydb.core.Flyway;

import dagger.Component;
import javax.inject.Singleton;

@Component(modules = { DatabaseModule.class })
@Singleton
public interface DatabaseComponent {

    Banner banner();

    HikariDataSource hikariDataSource();

    Flyway flyway();

    HikariConf hikariConf();
}
