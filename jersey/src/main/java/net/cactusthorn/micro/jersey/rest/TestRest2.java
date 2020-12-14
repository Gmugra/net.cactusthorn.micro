package net.cactusthorn.micro.jersey.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class TestRest2 implements EntryPoint {

    @Inject
    public TestRest2() {
    }

    @GET // GET request
    @Produces(MediaType.TEXT_PLAIN) // Response type
    @Path("ping2") // Endpoint path
    public String ping() {
        return "TestRest2@" + hashCode();
    }
}
