package net.cactusthorn.micro.jetty.logger;

import net.cactusthorn.micro.core.logger.LogbackCoreConfigurator;

public class LogbackJettyConfigurator extends LogbackCoreConfigurator {

    @Override
    protected String configFile() {
        return "logback-jetty.xml";
    }
}
