package net.cactusthorn.micro.db.jpahibernate.logger;

import net.cactusthorn.micro.core.logger.LogbackCoreConfigurator;

public class LogbackJPAHibernateConfigurator extends LogbackCoreConfigurator {

    @Override //
    protected String configFile() {
        return "logback-jpahibernate.xml";
    }
}
