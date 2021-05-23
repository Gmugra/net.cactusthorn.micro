package net.cactusthorn.micro.db.configuration;

import net.cactusthorn.config.core.Config;
import net.cactusthorn.config.core.Key;
import net.cactusthorn.config.core.Prefix;
import net.cactusthorn.config.core.Default;

import net.cactusthorn.config.extras.jasypt.PBEDecryptor;

@Config @Prefix("hikari") public interface HikariConf {

    @Default("org.postgresql.Driver") String driver();

    String url();

    @PBEDecryptor("pass") String username();

    @PBEDecryptor("pass") String password();

    String schema();

    @Key("minimum-idle") @Default("1") int minimumIdle();

    @Key("maximum-pool-size") @Default("5") int maximumPoolSize();

    @Default("MainPool") String poolname();
}
