package com.ankush.sampleproject.mapper;

import com.ankush.sampleproject.entity.Employee;
import com.ankush.sampleproject.entity.Movie;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
    id;
    public String Movie_Name;
    public String image_url;
    public String platform_link;

*/
public class MovieMapper implements ResultSetMapper<Movie> {
    private static final String ID="id";
   // private static final String MOVIE_NAME="Movie_Name";
    private static final String IMAGE_URL="image_url";
    private static final String PLATFORM_LINK="platform_url";

    public Movie map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Movie(resultSet.getInt(ID),resultSet.getString(IMAGE_URL),resultSet.getString(PLATFORM_LINK));
    }
}
