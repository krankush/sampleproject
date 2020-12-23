package com.ankush.sampleproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Map;

public class StreamingAvailability {
  @JsonProperty("country")
  public Map<String, ArrayList< Map<String,String> > > country;
  @JsonProperty("updatedAt")
  public UpdatedAt updatedAt;
}
