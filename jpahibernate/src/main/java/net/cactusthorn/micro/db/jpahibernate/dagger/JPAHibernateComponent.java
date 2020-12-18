package net.cactusthorn.micro.db.jpahibernate.dagger;

import javax.inject.Singleton;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import dagger.Component;
import net.cactusthorn.micro.core.banner.Banner;
import net.cactusthorn.micro.db.jpahibernate.service.TestJPAService;

@Singleton @Component(modules = { JPAHibernateModule.class }) //
public interface JPAHibernateComponent {

    Banner banner();

    Flyway flyway();

    DataSource dataSource();

    TestJPAService testJPAService();
}
