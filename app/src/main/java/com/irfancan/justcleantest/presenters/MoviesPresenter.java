package com.irfancan.justcleantest.presenters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.MoviesResponse;
import com.irfancan.justcleantest.models.RootResponse;
import com.irfancan.justcleantest.network.MovieApiService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesPresenter {


    private static Retrofit retrofit = null;


    public static Retrofit getClient(Context context) {


        //Retrofit will help us make the HTTP request
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public void getPopularMoviesRx(Context contextRef, final List<MoviesResponse> moviesResponses, final RecyclerView.Adapter mAdapter, final ProgressBar progressBar){

        MovieApiService apiService = getClient(contextRef.getApplicationContext())
                .create(MovieApiService.class);

        // Fetching all notes
        apiService.fetchPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("TEST SUCCESS","RETRIEVED");
                        progressBar.setVisibility(View.GONE);

                        moviesResponses.clear();
                        moviesResponses.addAll(rootResponse.getResults());

                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("TEST FAILED","FAILED");
                        progressBar.setVisibility(View.GONE);


                    }
                });



    }


    public void getTopRatedMoviesRx(Context contextRef, final List<MoviesResponse> moviesResponses, final RecyclerView.Adapter mAdapter, final ProgressBar progressBar){

        MovieApiService apiService = getClient(contextRef.getApplicationContext())
                .create(MovieApiService.class);

        // Fetching all notes
        apiService.fetchTopRatedMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("TEST SUCCESS","RETRIEVED");
                        progressBar.setVisibility(View.GONE);

                        moviesResponses.clear();
                        moviesResponses.addAll(rootResponse.getResults());

                        mAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("TEST FAILED","FAILED");
                        progressBar.setVisibility(View.GONE);


                    }
                });

    }


    public void getUpcomingMoviesRx(Context contextRef, final List<MoviesResponse> moviesResponses, final RecyclerView.Adapter mAdapter, final ProgressBar progressBar){

        MovieApiService apiService = getClient(contextRef.getApplicationContext())
                .create(MovieApiService.class);

        // Fetching all notes
        apiService.fetchUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("TEST SUCCESS","RETRIEVED");
                        progressBar.setVisibility(View.GONE);

                        moviesResponses.clear();
                        moviesResponses.addAll(rootResponse.getResults());

                        mAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("TEST FAILED","FAILED");
                        progressBar.setVisibility(View.GONE);


                    }
                });

    }


    public void getMovieFromSearchRx(Context contextRef, final List<MoviesResponse> moviesResponses, final RecyclerView.Adapter mAdapter, final ProgressBar progressBar, final FrameLayout listMoviesFrameLayout, String movieToBeSearched){

        MovieApiService apiService = getClient(contextRef.getApplicationContext())
                .create(MovieApiService.class);

        // Fetching all notes
        apiService.fetchMoviesBySearch(movieToBeSearched)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("TEST SUCCESS","RETRIEVED");
                        progressBar.setVisibility(View.GONE);

                        moviesResponses.clear();
                        moviesResponses.addAll(rootResponse.getResults());
                        listMoviesFrameLayout.setVisibility(View.VISIBLE);

                        mAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("TEST FAILED","FAILED");
                        progressBar.setVisibility(View.GONE);


                    }
                });


    }


}
