package net.cactusthorn.micro.db.configuration;

import static net.cactusthorn.micro.core.configuration.AppInfo.*;

import org.aeonbits.owner.Config;

@LoadPolicy(LoadType.MERGE) @Sources({ CONFIG_SYSTEM_PROPERTY, CONFIG_CURRENT_WORKING_FOLDER, CONFIG_CLASSPATH }) //
public interface FlywayConf extends Config {

    @Key("flyway.locations") @Separator(";") //
    public String[] locations();
}
