package com.ankush.sampleproject.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hi-path")
@Produces(MediaType.TEXT_HTML)
public class HiResource {
    @GET
    public String sayHi(@QueryParam("heading") String heading) {
        return "<html><body><h1 style='color:green'>"+heading+"</h1><br><p style='color:red'>My name is Khan and I am not a terrorist</p></body></html>";
    }
}
