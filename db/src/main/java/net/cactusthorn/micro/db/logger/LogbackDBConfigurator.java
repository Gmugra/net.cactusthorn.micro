package net.cactusthorn.micro.db.logger;

import net.cactusthorn.micro.core.logger.LogbackCoreConfigurator;

public class LogbackDBConfigurator extends LogbackCoreConfigurator {

    @Override
    protected String configFile() {
        return "logback-db.xml";
    }

}
