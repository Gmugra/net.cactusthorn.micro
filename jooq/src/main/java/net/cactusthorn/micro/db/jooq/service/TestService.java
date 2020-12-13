package net.cactusthorn.micro.db.jooq.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.*;

import static net.cactusthorn.micro.db.jooq.tables.Country.*;

@Singleton
public class TestService {

    private DSLContext dsl;

    @Inject
    public TestService(DSLContext dsl) {
        this.dsl = dsl;
    }

    public String doSelect() {

        Record2<String, String> result = dsl.select(COUNTRY.ALPHA2, COUNTRY.ALPHA3).from(COUNTRY).where(COUNTRY.ID.eq(1)).fetchOne();

        return result.get(COUNTRY.ALPHA3);
    }

}
