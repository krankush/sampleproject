package com.ankush.sampleproject.resources;

import com.ankush.sampleproject.entity.User;
import com.ankush.sampleproject.service.FetchNewArrivalsApi;
import com.ankush.sampleproject.service.MovieService;
import com.ankush.sampleproject.service.NameProcessor;
import com.ankush.sampleproject.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.skife.jdbi.v2.sqlobject.Bind;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
    private UserService userService;
    private MovieService movieService;
    private FetchNewArrivalsApi fetchNewArrivalsApi;
    public MovieResource( UserService userService,MovieService movieService,FetchNewArrivalsApi fetchNewArrivalsApi) {
        this.userService = userService;
        this.movieService = movieService;
        this.fetchNewArrivalsApi =fetchNewArrivalsApi;
    }
    @GET
    public Response getEmployees(){return Response.ok(movieService.getAllMovies()).build();}

    @GET
    @Path("/movie")
    public void printMovies(){fetchNewArrivalsApi.fetchDetailsFromApi("https://ott-details.p.rapidapi.com/getnew?region=IN&page=1",movieService);}

    @GET
    @Path("/retrieveNoOfMovies")
    public Response noOfMovies(){
        return Response.ok(movieService.noOfMoviesService()).build();
    }

    @GET
    @Path("/retrieveMovie")
    public Response getMoviesPagewise(@QueryParam("pageNo") int pageNo){return Response.ok(movieService.getAllMovieV1(pageNo,5)).build();}

    @POST
    @Path("/movie")
    public Response registerUser(String details) throws Exception {
        System.out.println(details);
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(details, User.class);
        System.out.println(user);
        int res = userService.registerUser(user);
        System.out.println("registerUser: "+res);
        return Response.ok(res).build();
//        return Response.ok().build();
    }

    /*
    public void printDetails(String details){
        System.out.println(details);
    }
    */


    // public void printDetails(){

    //}

}
/*
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
    @Path("/employee")
    public Response getEmployees(){return Response.ok(employeeService.getAllEmployees()).build();}

}
 */