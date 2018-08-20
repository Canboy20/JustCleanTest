package com.irfancan.justcleantest.network;

import android.provider.SyncStateContract;

import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.RootResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {

    // Fetch popular movies
    @GET("movie/popular?api_key="+Constants.API_KEY+"&language=en-US&page=1")
    Single<RootResponse> fetchPopularMovies();


    // Fetch top rated movies
    @GET("movie/top_rated?api_key="+Constants.API_KEY+"&language=en-US&page=1")
    Single<RootResponse> fetchTopRatedMovies();


    // Fetch upcoming movies
    @GET("movie/upcoming?api_key="+Constants.API_KEY+"&language=en-US&page=1")
    Single<RootResponse> fetchUpcomingMovies();

    // Fetch movies by search
    @GET("search/movie?api_key="+Constants.API_KEY+"&language=en-US")
    Single<RootResponse> fetchMoviesBySearch(@Query("query") String typedMovie);


}
