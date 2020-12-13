package net.cactusthorn.micro.db.jooq.dagger;

import net.cactusthorn.micro.db.dagger.DatabaseModule;
import net.cactusthorn.micro.db.jooq.configuration.*;

import org.aeonbits.owner.Factory;

import javax.inject.*;
import dagger.*;

import javax.sql.DataSource;

import org.jooq.*;
import org.jooq.impl.*;

@Module(includes = DatabaseModule.class)
public abstract class JooqModule {

    @Provides
    @Singleton
    public static JooqConf provideJooqConfig(Factory factory) {
        return factory.create(JooqConf.class);
    }

    @Provides
    @Singleton
    public static DSLContext provideDDLContext(DataSource dataSource, JooqConf conf) {

        org.jooq.Configuration jooqConfig = new DefaultConfiguration();
        jooqConfig.set(dataSource);
        jooqConfig.set(conf.dialect());

        return DSL.using(jooqConfig);
    }

}
