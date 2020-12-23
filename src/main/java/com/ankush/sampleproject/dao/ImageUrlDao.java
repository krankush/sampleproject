package com.ankush.sampleproject.dao;

import com.ankush.sampleproject.entity.ImageUrlMovieClass;
import com.ankush.sampleproject.mapper.ImageUrlMovieClassMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ImageUrlMovieClassMapper.class)
public interface ImageUrlDao {
    @SqlQuery("select imageUrl,imdbId from movieV1 limit :movieNo,:noOfMovies;")
    List<ImageUrlMovieClass> getMoviesImageUrl(@Bind("movieNo") int movieNo, @Bind("noOfMovies") int noOfMovies);

}
