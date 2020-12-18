package net.cactusthorn.micro.db.dagger;

import net.cactusthorn.micro.core.dagger.CoreModule;
import net.cactusthorn.micro.db.configuration.*;

import org.aeonbits.owner.Factory;

import javax.inject.*;
import dagger.*;

import javax.sql.DataSource;
import com.zaxxer.hikari.*;

import org.flywaydb.core.Flyway;

@Module(includes = CoreModule.class) //
public abstract class DatabaseModule {

    @Provides @Singleton //
    public static HikariConf provideHikariConf(Factory factory) {
        return factory.create(HikariConf.class);
    }

    @Provides @Singleton //
    public static FlywayConf provideFlywayConf(Factory factory) {
        return factory.create(FlywayConf.class);
    }

    @Provides @Singleton //
    public static HikariDataSource provideHikariDataSource(HikariConf conf) {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(conf.driver());
        hikariConfig.setJdbcUrl(conf.url());
        hikariConfig.setUsername(conf.username());
        hikariConfig.setPassword(conf.password());
        hikariConfig.setSchema(conf.schema());
        hikariConfig.setMinimumIdle(conf.minimumIdle());
        hikariConfig.setMaximumPoolSize(conf.maximumPoolSize());
        hikariConfig.setPoolName(conf.poolname());

        return new HikariDataSource(hikariConfig);
    }

    @Binds //
    public abstract DataSource bindDataSource(HikariDataSource hikariDataSource);

    @Provides @Singleton //
    public static Flyway provideFlyway(DataSource dataSource, FlywayConf conf) {
        return Flyway.configure().locations(conf.locations()).dataSource(dataSource).load();
    }

}
