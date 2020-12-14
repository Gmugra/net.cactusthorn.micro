package net.cactusthorn.micro.jetty.logger;

import net.cactusthorn.micro.core.logger.LogbackCoreConfigurator;

public class LogbackJettyJerseyConfigurator extends LogbackCoreConfigurator {

    @Override
    protected String configFile() {
        return "logback-jettyjersey.xml";
    }
}
