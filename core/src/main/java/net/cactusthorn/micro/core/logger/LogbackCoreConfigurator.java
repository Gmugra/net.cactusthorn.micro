package net.cactusthorn.micro.core.logger;

import java.io.IOException;
import java.io.InputStream;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackCoreConfigurator extends ContextAwareBase implements Configurator {

    @Override //
    public void configure(LoggerContext loggerContext) {
        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(loggerContext);
            try (InputStream in = getClass().getClassLoader().getResourceAsStream(configFile())) {
                configurator.doConfigure(in);
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        } catch (JoranException je) {
            // StatusPrinter will handle this
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
    }

    protected String configFile() {
        return "logback-core.xml";
    }

}
