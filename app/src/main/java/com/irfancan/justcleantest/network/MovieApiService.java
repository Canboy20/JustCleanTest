package com.irfancan.justcleantest.network;

import com.irfancan.justcleantest.models.RootResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MovieApiService {

    // Fetch popular movies
    @GET("popular?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1")
    Single<RootResponse> fetchPopularMovies();


    // Fetch top rated movies
    @GET("top_rated?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1")
    Single<RootResponse> fetchTopRatedMovies();


    // Fetch upcoming movies
    @GET("upcoming?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1")
    Single<RootResponse> fetchUpcomingMovies();

}
