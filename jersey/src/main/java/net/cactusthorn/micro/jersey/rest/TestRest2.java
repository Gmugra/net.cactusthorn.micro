package net.cactusthorn.micro.jersey.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;

@Path("api") //
public class TestRest2 implements EntryPoint {

    @Inject //
    public TestRest2() {
    }

    @GET @Produces(MediaType.TEXT_PLAIN) @Path("ping2") //
    public String ping() {
        return "TestRest2@" + this.hashCode();
    }
}
