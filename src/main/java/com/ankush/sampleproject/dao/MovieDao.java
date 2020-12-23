package com.ankush.sampleproject.dao;
import com.ankush.sampleproject.entity.*;
import com.ankush.sampleproject.mapper.ImageUrlMovieClassMapper;
import com.ankush.sampleproject.mapper.MovieMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;
@RegisterMapper(MovieMapper.class)
public interface MovieDao {
    @SqlQuery("select * from movie;")
    List<Movie> getMovies();

    @SqlQuery("select count(imdbId) from movieV1;")
    public int noOfMoviesDao();



    @SqlUpdate("insert into movieV1(imageUrl,imdbId,imdbRating,released,runtime,synopsis,title,type,platform,url) value (:imageUrl,:imdbId,:imdbRating,:released,:runtime,:synopsis,:title,:type,:platform,:url);")
    public void movieV1 (@Bind("imageUrl") String imageUrl,@Bind("imdbId") String imdbId, @Bind("imdbRating") double imdbRating, @Bind("released") int released,@Bind("runtime") String runtime,@Bind("synopsis") String synopsis,@Bind("title") String title,@Bind("type") String type,@Bind("platform") String platform,@Bind("url") String url);
    @SqlUpdate("insert into genreMovie(genre,imdbId) values (:genre,:imdbId);")
    public void genreMovie(@Bind("genre") String genre,@Bind("imdbId") String imdbId );
//    @SqlUpdate("insert into imageUrlMovie(imageUrl,imdbId) values (:imageUrl,:imdbId);")
//    public void imageUrlMovie(@Bind("imageUrl") String imageUrl,@Bind("imdbId") String imdbId );
    @SqlUpdate("insert into languageMovie(language,imdbId) values (:language,:imdbId);")
    public void languageMovie(@Bind("language") String language,@Bind("imdbId") String imdbId );
    public void streamingAvailabilityMoviesPlatform(@Bind("streamingAvailabilityPlatform") String streamingAvailabilityPlatform, @Bind("imdbId") String imdbId );
    public void streamingAvailabilityMoviesUrl(@Bind("streamingAvailabilityUrl") String streamingAvailabilityUrl, @Bind("imdbId") String imdbId );



   // @SqlQuery("select * from movieV1 limit :pageNo*noOfRows,:noOfRows;")
   // List<MovieV1Class> getMovieV1();

    // @SqlUpdate("insert into user (name, email_id, password) values ( :name , :email , :password)")
   // int createUser(@Bind("name") String name, @Bind("email") String email, @Bind("password") String password);
}
