package com.ankush.sampleproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Result {
    @JsonProperty("genre")
    public ArrayList<String> genre;
    @JsonProperty("imageurl")
    public ArrayList<String> imageUrl;
    @JsonProperty("imdbid")
    public String imdbId;
    @JsonProperty("imdbrating")
    public double imdbRating;
    @JsonProperty("language")
    public ArrayList<String> language;
    @JsonProperty("released")
    public int released;
    @JsonProperty("runtime")
    public String runtime;
    @JsonProperty("streamingAvailability")
    public StreamingAvailability streamingAvailability;
    @JsonProperty("synopsis")
    public String synopsis;
    @JsonProperty("title")
    public String title;
    @JsonProperty("type")
    public String type;


    @Override
    public String toString() {
        return "Result{" +
                "genre=" + genre +
                ", imageUrl=" + imageUrl +
                ", imdbId='" + imdbId + '\'' +
                ", imdbRating=" + imdbRating +
                ", language=" + language +
                ", released=" + released +
                ", runtime='" + runtime + '\'' +
                ", streamingAvailability=" + streamingAvailability +
                ", synopsis='" + synopsis + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
