package com.ankush.sampleproject.service;

import com.ankush.sampleproject.dao.ImageUrlDao;
import com.ankush.sampleproject.dao.MovieDao;
import com.ankush.sampleproject.entity.ImageUrlMovieClass;
import com.ankush.sampleproject.entity.Movie;
import com.ankush.sampleproject.entity.MovieList;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import java.util.List;

public abstract class MovieService {
    @CreateSqlObject
    abstract MovieDao getMovieDao();

    @CreateSqlObject
    abstract ImageUrlDao getImageUrlDao();

    public List<Movie> getAllMovies(){
        return getMovieDao().getMovies();
    }

    public int noOfMoviesService(){
        int val=getMovieDao().noOfMoviesDao();
        System.out.println("Value====");
        System.out.println(val);
        return val;
    }

    public List<ImageUrlMovieClass> getAllMovieV1(int pageNo, int noOfMovies){
        List<ImageUrlMovieClass> movieList=getImageUrlDao().getMoviesImageUrl((pageNo-1)*noOfMovies,noOfMovies);
        System.out.println(movieList.get(0).imageUrl);
        return movieList;
    }

    public void setMovie(MovieList movieList) {
        System.out.println("======");
        System.out.println(movieList.results.size());
        for (int i = 0; i < movieList.results.size(); i++) {
   //        int i=0;
            System.out.println("-----");

            if(movieList.results.get(i).imageUrl.size()==0){
                continue;
            }
            String StreamingAvailabilityPlatform="";
            String StreamingAvailabilityPlatformUrl="";
            if(movieList.results.get(i).streamingAvailability.country.get("IN").size()>0){
                StreamingAvailabilityPlatform=movieList.results.get(i).streamingAvailability.country.get("IN").get(0).get("platform");
                StreamingAvailabilityPlatformUrl=movieList.results.get(i).streamingAvailability.country.get("IN").get(0).get("url");

                getMovieDao().movieV1(movieList.results.get(i).imageUrl.get(0),movieList.results.get(i).imdbId, movieList.results.get(i).imdbRating, movieList.results.get(i).released, movieList.results.get(i).runtime, movieList.results.get(i).synopsis, movieList.results.get(i).title, movieList.results.get(i).type,StreamingAvailabilityPlatform,StreamingAvailabilityPlatformUrl);

                for (int j = 0; j < movieList.results.get(i).genre.size(); j++) {
                    getMovieDao().genreMovie(movieList.results.get(i).genre.get(j), movieList.results.get(i).imdbId);
                }
                for (int j = 0; j < movieList.results.get(i).language.size(); j++) {
                    getMovieDao().languageMovie(movieList.results.get(i).language.get(j), movieList.results.get(i).imdbId);
                }

            }
            // if(movieList.results.get(i).imageUrl.get(0),movieList.results.get(i).imdbId, movieList.results.get(i).imdbRating, movieList.results.get(i).released, movieList.results.get(i).runtime, movieList.results.get(i).synopsis, movieList.results.get(i).title, movieList.results.get(i).type,movieList.results.get(i).streamingAvailability.country.get("IN").get(0).get("platform"),movieList.results.get(i).streamingAvailability.country.get("IN").get(0).get("url"))
        }
    }
}
/*
public abstract class EmployeeService {

    @CreateSqlObject
    abstract EmployeeDao getEmployeeDao();

    public List<Employee> getAllEmployees(){
        return getEmployeeDao().getEmployees();
    }
}

*/