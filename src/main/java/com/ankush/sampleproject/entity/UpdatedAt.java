package com.ankush.sampleproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UpdatedAt {
    @JsonProperty("country")
    public Map<String, Map<String,String>>  countryUpdatedAt;
}
