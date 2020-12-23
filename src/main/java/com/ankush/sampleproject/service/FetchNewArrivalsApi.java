package com.ankush.sampleproject.service;

import com.ankush.sampleproject.dao.MovieDao;
import com.ankush.sampleproject.entity.Movie;
import com.ankush.sampleproject.entity.MovieList;
import com.ankush.sampleproject.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import javax.ws.rs.core.Response;
import java.io.IOException;

public class FetchNewArrivalsApi {

    private String getReq(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("x-rapidapi-key" , "44c99e0a14msh16b5caa7d35a86cp19761fjsn0a38e5bfa073");
        httpGet.addHeader("x-rapidapi-host", "ott-details.p.rapidapi.com");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet)) {

            Assert.assertEquals(200, response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }
    }
    public void fetchDetailsFromApi(String url,MovieService movieService) {
        String details= null;
        try {
            details = getReq(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(details);


        //public  MovieService movieService;
        ObjectMapper objectMapper = new ObjectMapper();
        MovieList movieList = null;
        try {
            movieList = objectMapper.readValue(details, MovieList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(movieList);

        //MovieService movieService = new MovieService();
        movieService.setMovie(movieList);
    }

}
