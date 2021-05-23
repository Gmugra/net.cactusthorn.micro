package net.cactusthorn.micro.db.configuration;

import java.util.List;

import net.cactusthorn.config.core.Config;
import net.cactusthorn.config.core.Key;

@Config public interface FlywayConf {

    @Key("flyway.locations") public List<String> locations();
}
