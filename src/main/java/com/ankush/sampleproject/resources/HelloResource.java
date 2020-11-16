package com.ankush.sampleproject.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-path")
@Produces(MediaType.TEXT_PLAIN)
public class HelloResource {
    @GET
    public String sayHello(@QueryParam("name") String Name){
        System.out.println("HelloResource ,aise/ to sampoorn brahmand meri agyan se");
        return "xyz>";
    }
}
