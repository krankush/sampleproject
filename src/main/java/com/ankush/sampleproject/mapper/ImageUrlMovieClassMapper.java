package com.ankush.sampleproject.mapper;

import com.ankush.sampleproject.entity.ImageUrlMovieClass;
import com.ankush.sampleproject.entity.Movie;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageUrlMovieClassMapper implements ResultSetMapper<ImageUrlMovieClass> {
    public ImageUrlMovieClass map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new ImageUrlMovieClass(
                resultSet.getString("imageUrl"),
                resultSet.getString("imdbId")
        );
    }
}
