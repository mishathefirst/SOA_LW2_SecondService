package com.example.SimpleJAXRS.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello-world")
public class HelloResource {
    @GET
    //@Produces("text/plain")
    public Response hello() {
        return Response.ok().entity("This is JAX-RS").build();
        //return Response.ok().status(200).build();
        //return "Hello, World!";
    }
}