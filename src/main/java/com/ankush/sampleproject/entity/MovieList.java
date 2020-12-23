package com.ankush.sampleproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovieList {

    public int page;
    public ArrayList<Result> results;

    @Override
    public String toString(){
        return "MovieId="+page+
                "  image=  "+results.toString()+
                '}';
    }
}
