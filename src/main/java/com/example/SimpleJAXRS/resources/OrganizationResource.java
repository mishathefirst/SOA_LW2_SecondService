package com.example.SimpleJAXRS.resources;

import com.example.SimpleJAXRS.entities.Organization;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/")
public class OrganizationResource {

    private static final String REST_URI = "https://localhost:8081/organizations/1";

    @GET
    @Path("/merge/{id1}/{id2}/{name}/{address}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response merge(@PathParam("id1") int id1, @PathParam("id2") int id2, @PathParam("name") String name,
                          @PathParam("address") String address) {
        //getOrg(1);

        /*
        Client client = ClientBuilder.newClient();
        URI uri = UriBuilder.fromUri(REST_URI).build();
        String resp = client.target(uri).request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(resp);

         */


        return Response.ok()
                .entity(new Organization(id1, name, address))
                .build();
    }

    @GET
    @Path("/acquise/{id1}/{id2}")
    public Response acquise(@PathParam("id1") int id1, @PathParam("id2") int id2) {

        System.out.println(id1);
        System.out.println(id2);
        return Response.ok().build();
    }

/*

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
                .entity(new Notification(id, "john", "test notification"))
                .build();
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(Notification notification) {
        return Response.status(201).entity(notification).build();
    }

 */

}