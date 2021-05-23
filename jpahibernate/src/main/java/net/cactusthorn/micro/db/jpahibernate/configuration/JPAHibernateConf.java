package net.cactusthorn.micro.db.jpahibernate.configuration;

import net.cactusthorn.config.core.Config;
import net.cactusthorn.config.core.Disable;
import net.cactusthorn.config.core.Disable.Feature;
import net.cactusthorn.config.core.Key;
import net.cactusthorn.config.core.Prefix;

@Config @Prefix("hibernate") public interface JPAHibernateConf {

    @Disable(Feature.PREFIX) @Key("jpa.persistenceUnitName") String persistenceUnitName();

    String dialect();

    boolean show_sql();
}
