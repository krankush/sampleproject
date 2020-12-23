package com.ankush.sampleproject.mapper;

import com.ankush.sampleproject.entity.FinalMovieV1DatabaseStructure;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FinalMovieV1DatabaseStructureMapper implements ResultSetMapper<FinalMovieV1DatabaseStructure> {
    private static final String imageUrl="imageUrl";
    private static final String imdbId="imdbId";
    private static final String imdbRating="imdbRating";
    private static final String released="released";
    private static final String runtime="runtime";
    private static final String synopsis="synopsis";
    private static final String title="title";
    private static final String type="type";
    private static final String platform="platform";
    private static final String url="url";

    public FinalMovieV1DatabaseStructure map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new FinalMovieV1DatabaseStructure(
                resultSet.getString(imageUrl),
                resultSet.getString(imdbId),
                resultSet.getDouble(imdbRating),
                resultSet.getInt(released),
                resultSet.getString(runtime),
                resultSet.getString(synopsis),
                resultSet.getString(title),
                resultSet.getString(type),
                resultSet.getString(platform),
                resultSet.getString(url)
        );
    }
}
