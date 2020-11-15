package com.ankush.sampleproject;

import com.ankush.sampleproject.resources.HelloResource;
import com.ankush.sampleproject.resources.HiResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class HiApplication extends Application<HiConfiguration> {
    public static void main(String[] args) throws Exception {
        new HiApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HiConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HiConfiguration configuration,
                    Environment environment) {


        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        HiResource resource = new HiResource();
        environment.jersey().register(resource);
        HelloResource helloResource= new HelloResource();
        environment.jersey().register(helloResource);
    }
}
