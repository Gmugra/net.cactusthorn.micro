package net.cactusthorn.micro.db.jpahibernate.configuration;

import static net.cactusthorn.micro.core.configuration.AppInfo.*;

import org.aeonbits.owner.Config;

@LoadPolicy(LoadType.MERGE)
@Sources({ CONFIG_SYSTEM_PROPERTY, CONFIG_CURRENT_WORKING_FOLDER, CONFIG_CLASSPATH })
public interface JPAHibernateConf extends Config {

    @Key("jpa.persistenceUnitName")
    String persistenceUnitName();

    @Key("hibernate.dialect")
    String dialect();

    @Key("hibernate.show_sql")
    boolean show_sql();
}
