package net.cactusthorn.micro.db.jpahibernate.dagger;

import java.util.*;

import javax.inject.*;

import javax.persistence.*;
import javax.sql.DataSource;

import dagger.Module;
import dagger.Provides;
import net.cactusthorn.config.core.factory.ConfigFactory;
import net.cactusthorn.micro.db.dagger.DatabaseModule;
import net.cactusthorn.micro.db.jpahibernate.configuration.JPAHibernateConf;

@Module(includes = DatabaseModule.class) public class JPAHibernateModule {

    @Provides @Singleton //
    public static JPAHibernateConf provideJPAHibernateConf(ConfigFactory factory) {
        return factory.create(JPAHibernateConf.class);
    }

    @Provides @Singleton //
    public static EntityManagerFactory provideEntityManagerFactory(DataSource dataSource, JPAHibernateConf conf) {

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("javax.persistence.nonJtaDataSource", dataSource);
        props.put("hibernate.dialect", conf.dialect());
        props.put("hibernate.show_sql", conf.show_sql());

        return Persistence.createEntityManagerFactory(conf.persistenceUnitName(), props);
    }
}
