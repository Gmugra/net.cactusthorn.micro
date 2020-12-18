package net.cactusthorn.micro.jetty.dagger;

import net.cactusthorn.micro.core.banner.Banner;
import net.cactusthorn.micro.core.dagger.entrypoint.ApplicationComponent;
import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;
import net.cactusthorn.micro.core.dagger.entrypoint.EntryPointComponentBuilder;
import net.cactusthorn.micro.db.jooq.dagger.JooqModule;
import net.cactusthorn.micro.jersey.dagger.RequestScopeModule;
import net.cactusthorn.micro.jersey.dagger.SessionScopeBuilderModule;
import dagger.*;

import java.util.Map;

import javax.inject.*;

import org.flywaydb.core.Flyway;

@Singleton @Component(modules = { RequestScopeModule.class, SessionScopeBuilderModule.class, JooqModule.class }) //
public interface JettyComponent extends ApplicationComponent {

    @Override //
    public Map<Class<?>, Provider<EntryPoint>> requestScopeEntryPoints();

    @Override @SuppressWarnings("rawtypes") //
    public EntryPointComponentBuilder sessionScopeComponentBuilder();

    Banner banner();

    Flyway flyway();
}
