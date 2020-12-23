package com.ankush.sampleproject.entity;

public class Movie {
    public Integer id;
    //public String Movie_Name;
    public String image_url;
    public String platform_link;
    public Movie(Integer id,String image_url,String platform_link){
        this.id=id;
       // this.Movie_Name=Movie_Name;
        this.image_url=image_url;
        this.platform_link = platform_link;
    }

    @Override
    public String toString(){
            return "MovieId="+id+
                "  image=  "+image_url+"  platform Link = "+platform_link+
                '}';
    }
}
