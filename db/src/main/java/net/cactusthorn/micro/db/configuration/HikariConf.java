package net.cactusthorn.micro.db.configuration;

import static net.cactusthorn.micro.core.configuration.AppInfo.*;

import org.aeonbits.owner.Config;

import net.cactusthorn.micro.core.configuration.owner.crypto.PasswordDecryptor;

@LoadPolicy(LoadType.MERGE)
@Sources({ CONFIG_SYSTEM_PROPERTY, CONFIG_CURRENT_WORKING_FOLDER, CONFIG_CLASSPATH })
public interface HikariConf extends Config {

    @Key("hikari.driver")
    @DefaultValue("org.postgresql.Driver")
    String driver();

    @Key("hikari.url")
    String url();

    @Key("hikari.username")
    @EncryptedValue( PasswordDecryptor.class )
    String username();

    @Key("hikari.password")
    @EncryptedValue( PasswordDecryptor.class )
    String password();

    @Key("hikari.schema")
    String schema();

    @Key("hikari.minimum-idle")
    @DefaultValue("1")
    int minimumIdle();

    @Key("hikari.maximum-pool-size")
    @DefaultValue("5")
    int maximumPoolSize();

    @Key("hikari.poolname")
    @DefaultValue("MainPool")
    String poolname();
}
