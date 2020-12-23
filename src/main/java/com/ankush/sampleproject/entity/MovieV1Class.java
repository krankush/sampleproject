package com.ankush.sampleproject.entity;

public class MovieV1Class {
    public String imdbId;
    public double imdbRating;
    public int released;
    public String runtime;
    public  String synopsis;
    public String title;
    public String type;
    public String platform;
    public  String url;
    public MovieV1Class(String imdbId,double imdbRating,int released,String runtime,String synopsis,String title,String type,
            String platform,String url){
        this.imdbId=imdbId;
        // this.Movie_Name=Movie_Name;
        this.released=released;
        this.runtime = runtime;
        this.synopsis=synopsis;
        this.title=title;
        this.type=type;
        this.platform=platform;
        this.url=url;
    }


}


