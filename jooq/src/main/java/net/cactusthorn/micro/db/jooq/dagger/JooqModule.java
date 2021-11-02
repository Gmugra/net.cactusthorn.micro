package net.cactusthorn.micro.db.jooq.dagger;

import net.cactusthorn.config.core.factory.ConfigFactory;
import net.cactusthorn.micro.db.dagger.DatabaseModule;
import net.cactusthorn.micro.db.jooq.configuration.*;

import javax.inject.*;

import javax.sql.DataSource;

import org.jooq.*;
import org.jooq.impl.*;

import dagger.Module;
import dagger.Provides;

@Module(includes = DatabaseModule.class) //
public abstract class JooqModule {

    @Provides @Singleton //
    public static JooqConf provideJooqConfig(ConfigFactory factory) {
        return factory.create(JooqConf.class);
    }

    @Provides @Singleton //
    public static DSLContext provideDDLContext(DataSource dataSource, JooqConf conf) {

        org.jooq.Configuration jooqConfig = new DefaultConfiguration();
        jooqConfig.set(dataSource);
        jooqConfig.set(conf.dialect());

        return DSL.using(jooqConfig);
    }

}
