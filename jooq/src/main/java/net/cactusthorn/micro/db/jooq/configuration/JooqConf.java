package net.cactusthorn.micro.db.jooq.configuration;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.*;

import static net.cactusthorn.micro.core.configuration.AppInfo.*;

import org.jooq.SQLDialect;

@LoadPolicy(LoadType.MERGE) @Sources({ CONFIG_SYSTEM_PROPERTY, CONFIG_CURRENT_WORKING_FOLDER, CONFIG_CLASSPATH }) //
public interface JooqConf extends Config {

    @Key("jooq.dialect") @DefaultValue("POSTGRES") //
    SQLDialect dialect();
}
