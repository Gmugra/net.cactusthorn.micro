package net.cactusthorn.micro.db.jooq;

import net.cactusthorn.micro.db.jooq.dagger.DaggerJooqComponent;
import net.cactusthorn.micro.db.jooq.dagger.JooqComponent;

public class JooqApplication {

    public static void main(String... args) {

        JooqComponent component = DaggerJooqComponent.create();

        component.banner().show();

        component.flyway().migrate();

        component.testService().doSelect();

    }
}
