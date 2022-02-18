package com.example.SimpleJAXRS.resources;

import com.example.SimpleJAXRS.cruds.EmployeeCRUD;
import com.example.SimpleJAXRS.entities.Employee;
import com.example.SimpleJAXRS.entities.Organization;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@Path("/")
public class OrganizationResource {



    @GET
    @Path("/merqe/{id1}/{id2}/{name}/{address}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response merge(@PathParam("id1") int id1, @PathParam("id2") int id2, @PathParam("name") String name,
                          @PathParam("address") String address) {

        String REST_URI = "http://localhost:8079/producer/organizations/";


        Client client = ClientBuilder.newClient();
        URI uri_org_1 = UriBuilder.fromUri(REST_URI.concat(String.valueOf(id1))).build();
        URI uri_org_2 = UriBuilder.fromUri(REST_URI.concat(String.valueOf(id2))).build();
        //String resp = client.target(uri).request(MediaType.APPLICATION_JSON).get(String.class);


        Organization org1 = client.target(uri_org_1).request(MediaType.APPLICATION_JSON).get(Organization.class);
        Organization org2 = client.target(uri_org_2).request(MediaType.APPLICATION_JSON).get(Organization.class);
        Organization orgNew = new Organization();


        EmployeeCRUD empCRUD = new EmployeeCRUD();
        List<Employee> employeeList = empCRUD.getAll();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getOrgId() == id2) {
                employeeList.get(i).setOrgId((long) id1);
                empCRUD.update(employeeList.get(i));
            }
        }


        orgNew.setId((long) id1);
        orgNew.setName(name);
        orgNew.setTown(address);
        orgNew.setAnnualTurnover(org1.getAnnualTurnover() + org2.getAnnualTurnover());

        client.target(uri_org_1).request().delete();
        client.target(uri_org_2).request().delete();

        client.target(uri_org_1).request(MediaType.APPLICATION_JSON).post(Entity.json(orgNew), Organization.class);



        return Response.ok()
                .entity("employee")
                //.entity(new Organization(id1, name, address))
                .build();
    }

    @GET
    @Path("/acguise/{id1}/{id2}")
    public Response acquise(@PathParam("id1") int id1, @PathParam("id2") int id2) {

        String REST_URI = "http://localhost:8079/producer/organizations/";


        Client client = ClientBuilder.newClient();
        URI uri_org_1 = UriBuilder.fromUri(REST_URI.concat(String.valueOf(id1))).build();
        URI uri_org_2 = UriBuilder.fromUri(REST_URI.concat(String.valueOf(id2))).build();
        //String resp = client.target(uri).request(MediaType.APPLICATION_JSON).get(String.class);


        Organization org1 = client.target(uri_org_1).request(MediaType.APPLICATION_JSON).get(Organization.class);
        Organization org2 = client.target(uri_org_2).request(MediaType.APPLICATION_JSON).get(Organization.class);
        //Organization orgNew = new Organization();


        EmployeeCRUD empCRUD = new EmployeeCRUD();
        List<Employee> employeeList = empCRUD.getAll();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getOrgId() == id2) {
                employeeList.get(i).setOrgId((long) id1);
                empCRUD.update(employeeList.get(i));
            }
        }


        org1.setAnnualTurnover(org1.getAnnualTurnover() + org2.getAnnualTurnover());

        client.target(uri_org_2).request().delete();

        //TODO: updating the org1

        return Response.ok().build();
    }


    @GET
    @Path("/getresp")
    public Response getresp() {
        //Client client = ClientBuilder.newClient();
        //URI uri_org_1 = UriBuilder.fromUri(REST_URI.concat(String.valueOf(id1))).build();
        //URI uri_org_2 = UriBuilder.fromUri(REST_URI.concat(String.valueOf(id2))).build();
        //String resp = client.target(uri).request(MediaType.APPLICATION_JSON).get(String.class);


        //Organization org1 = client.target(uri_org_1).request(MediaType.APPLICATION_JSON).get(Organization.class);
        //Organization org2 = client.target(uri_org_2).request(MediaType.APPLICATION_JSON).get(Organization.class);
        //Organization orgNew = new Organization();


        EmployeeCRUD empCRUD = new EmployeeCRUD();
        List<Employee> employeeList = empCRUD.getAll();

        /*
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getOrgId() == id2) {
                employeeList.get(i).setOrgId((long) id1);
                empCRUD.update(employeeList.get(i));
            }
        }



        orgNew.setId((long) id1);
        orgNew.setName(name);
        orgNew.setTown(address);
        orgNew.setAnnualTurnover(org1.getAnnualTurnover() + org2.getAnnualTurnover());

        client.target(uri_org_1).request().delete();
        client.target(uri_org_2).request().delete();

        client.target(uri_org_1).request(MediaType.APPLICATION_JSON).post(Entity.json(orgNew), Organization.class);



         */

        return Response.ok()
                .entity(employeeList)
                //.entity(new Organization(id1, name, address))
                .build();
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