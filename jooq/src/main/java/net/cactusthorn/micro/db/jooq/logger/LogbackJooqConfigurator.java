package net.cactusthorn.micro.db.jooq.logger;

import net.cactusthorn.micro.core.logger.LogbackCoreConfigurator;

public class LogbackJooqConfigurator extends LogbackCoreConfigurator {

    @Override
    protected String configFile() {
        return "logback-jooq.xml";
    }
}
