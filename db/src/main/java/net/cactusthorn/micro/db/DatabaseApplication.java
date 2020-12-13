package net.cactusthorn.micro.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.db.dagger.*;

public class DatabaseApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseApplication.class);

    public static void main(String... args) {

        DatabaseComponent component = DaggerDatabaseComponent.create();

        LOG.info("Maximum Pool Size: {}", component.hikariConf().maximumPoolSize());

        component.banner().show();

        component.flyway().migrate();

        component.hikariDataSource().close();

    }
}
