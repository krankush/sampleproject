package com.ankush.sampleproject;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SampleProjectConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty("database")
    public DataSourceFactory dataSourceFactory = new DataSourceFactory();
}
