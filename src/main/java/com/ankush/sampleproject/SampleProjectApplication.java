package com.ankush.sampleproject;

import com.ankush.sampleproject.entity.Employee;
import com.ankush.sampleproject.resources.HelloResource;
import com.ankush.sampleproject.resources.HiResource;
import com.ankush.sampleproject.service.EmployeeService;
import com.ankush.sampleproject.service.NameProcessor;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.util.Duration;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.util.EnumSet;

public class SampleProjectApplication extends Application<SampleProjectConfiguration> {
    public static void main(String[] args) throws Exception {
        new SampleProjectApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SampleProjectConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(SampleProjectConfiguration configuration,
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

        final DataSource dataSource =
                configuration.dataSourceFactory.build(environment.metrics(), "sql");
        DBI dbi = new DBI(dataSource);


        HiResource resource = new HiResource();
        environment.jersey().register(resource);
        HelloResource helloResource= new HelloResource(new NameProcessor(), dbi.onDemand(EmployeeService.class));
        environment.jersey().register(helloResource);
    }
}
