package net.cactusthorn.micro.core.configuration;

import java.util.List;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({ "jar:///manifest?Application-Name=MICRO" })
public interface AppInfo extends Config {

    String CONFIG_FILE_NAME = "micro.properties";
    String CONFIG_SYSTEM_PROPERTY = "file:/${micro-config-path}/" + CONFIG_FILE_NAME;
    String CONFIG_CURRENT_WORKING_FOLDER = "file:./" + CONFIG_FILE_NAME;
    String CONFIG_CLASSPATH = "classpath:" + CONFIG_FILE_NAME;

    @Key("Implementation-Version")
    @DefaultValue("unknown")
    String version();

    @Key("Build-Time")
    @DefaultValue("unknown")
    String buildTime();

    @Key("Implementation-Title")
    @DefaultValue("unknown")
    String title();

    @Separator(" ")
    @Key("Class-Path")
    @DefaultValue("unknown")
    List<String> classPath();
}
