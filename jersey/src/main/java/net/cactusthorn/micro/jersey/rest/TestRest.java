package net.cactusthorn.micro.jersey.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;
import net.cactusthorn.micro.db.jooq.service.TestService;

@Path("api") //
public class TestRest implements EntryPoint {

    private TestService testService;

    @Inject //
    public TestRest(TestService testService) {
        this.testService = testService;
    }

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("ping") //
    public TestRestPingResponse ping() {

        String result = testService.doSelect();

        return new TestRestPingResponse(result);
    }

}
