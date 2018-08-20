package com.irfancan.justcleantest.network;

import com.irfancan.justcleantest.models.RootResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {

    // Fetch popular movies
    @GET("movie/popular?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1")
    Single<RootResponse> fetchPopularMovies();


    // Fetch top rated movies
    @GET("movie/top_rated?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1")
    Single<RootResponse> fetchTopRatedMovies();


    // Fetch upcoming movies
    @GET("movie/upcoming?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1")
    Single<RootResponse> fetchUpcomingMovies();

    // Fetch movies by search
    @GET("search/movie?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US")
    Single<RootResponse> fetchMoviesBySearch(@Query("query") String typedMovie);


}
