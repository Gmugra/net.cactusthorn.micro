package net.cactusthorn.micro.jersey.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.cactusthorn.micro.core.dagger.SessionScope;
import net.cactusthorn.micro.core.dagger.entrypoint.EntryPoint;

@SessionScope @Path("api") //
public class TestSessionScope implements EntryPoint {

    private int counter = 0;

    @Inject //
    public TestSessionScope() {
    }

    @GET @Produces(MediaType.TEXT_PLAIN) @Path("count") //
    public String count() {
        counter++;
        return "TestSessionScope2@" + hashCode() + " :: " + counter;
    }
}
