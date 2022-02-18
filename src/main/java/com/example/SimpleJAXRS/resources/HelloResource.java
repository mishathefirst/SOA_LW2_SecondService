package com.example.SimpleJAXRS.resources;

import com.example.SimpleJAXRS.cruds.EmployeeCRUD;
import com.example.SimpleJAXRS.cruds.OrganizationCRUD;
import com.example.SimpleJAXRS.entities.Employee;
import com.example.SimpleJAXRS.entities.Organization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@Path("/")
public class HelloResource {
    @GET
    public Response hello() {
        return Response.ok().entity("This is JAX-RS").build();

    }



































        @GET
        @Path("/merge/{id1}/{id2}/{name}/{address}")
        public Response merge(@PathParam("id1") int id1, @PathParam("id2") int id2, @PathParam("name") String name,
                              @PathParam("address") String address) {

            EmployeeCRUD empCRUD = new EmployeeCRUD();
            OrganizationCRUD orgCRUD = new OrganizationCRUD();

            Organization org1 = orgCRUD.getById((long) id1);
            Organization org2 = orgCRUD.getById((long) id2);
            Organization orgNew = new Organization();

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

            //client.target(uri_org_1).request().delete();
            //client.target(uri_org_2).request().delete();

            //orgCRUD.delete(org1);
            orgCRUD.delete(org2);

            //client.target(uri_org_1).request(MediaType.APPLICATION_JSON).post(Entity.json(orgNew), Organization.class);

            orgNew.setCoordinatex(org1.getCoordinatex());
            orgNew.setCoordinatey(org1.getCoordinatey());
            orgNew.setCreationDate(org1.getCreationDate());
            orgNew.setType(org1.getType());

            orgCRUD.update(orgNew);

            return Response.ok()
                    //.entity("employee")
                    //.entity(new Organization(id1, name, address))
                    .build();
        }

        @GET
        @Path("/acquise/{id1}/{id2}")
        public Response acquise(@PathParam("id1") int id1, @PathParam("id2") int id2) {

            EmployeeCRUD empCRUD = new EmployeeCRUD();
            OrganizationCRUD orgCRUD = new OrganizationCRUD();

            Organization org1 = orgCRUD.getById((long) id1);
            Organization org2 = orgCRUD.getById((long) id2);


            List<Employee> employeeList = empCRUD.getAll();

            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getOrgId() == id2) {
                    employeeList.get(i).setOrgId((long) id1);
                    empCRUD.update(employeeList.get(i));
                }
            }


            org1.setAnnualTurnover(org1.getAnnualTurnover() + org2.getAnnualTurnover());
            orgCRUD.delete(org2);

            orgCRUD.update(org1);

            //client.target(uri_org_2).request().delete();

            return Response.ok().build();
        }








































}