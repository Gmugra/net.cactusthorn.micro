package net.cactusthorn.micro.core.configuration;

import java.util.List;

import net.cactusthorn.config.core.Config;
import net.cactusthorn.config.core.Key;
import net.cactusthorn.config.core.Default;
import net.cactusthorn.config.core.Split;

@Config(sources="classpath:jar:manifest?Application-Name=MICRO") //
public interface AppInfo {

    @Key("Implementation-Version") @Default("unknown") //
    String version();

    @Key("Build-Time") @Default("unknown") //
    String buildTime();

    @Key("Implementation-Title") @Default("unknown") //
    String title();

    @Key("Class-Path") //
    @Split(" ") //
    @Default("unknown") //
    List<String> classPath();
}
