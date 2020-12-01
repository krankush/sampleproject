package com.ankush.sampleproject.resources;

import com.ankush.sampleproject.service.EmployeeService;
import com.ankush.sampleproject.service.NameProcessor;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello-path")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    private NameProcessor nameProcessor;
    private EmployeeService employeeService;


    public HelloResource(NameProcessor nameProcessor, EmployeeService employeeService) {
        this.nameProcessor = nameProcessor;
        this.employeeService = employeeService;
    }

    @GET
    public String sayHello(@QueryParam("name") String name){
        return nameProcessor.getLastName(name);
    }

    @GET
    @Path("/xyz")
    public String sayHelloxyz(@QueryParam("name") String name){
        return nameProcessor.getLastName(name);
    }

    @GET
    @Timed
    @Path("/employee")
    public Response getEmployees(){return Response.ok(employeeService.getAllEmployees()).build();}

}
