package net.cactusthorn.micro.db.jooq.configuration;

import org.jooq.SQLDialect;

import net.cactusthorn.config.core.Config;
import net.cactusthorn.config.core.Default;
import net.cactusthorn.config.core.Prefix;

@Config @Prefix("jooq") public interface JooqConf {

    @Default("POSTGRES") SQLDialect dialect();
}
