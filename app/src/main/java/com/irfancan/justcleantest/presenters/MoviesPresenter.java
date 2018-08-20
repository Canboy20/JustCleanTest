package com.irfancan.justcleantest.presenters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.MoviesResponse;
import com.irfancan.justcleantest.models.RootResponse;
import com.irfancan.justcleantest.network.MovieApiService;
import com.irfancan.justcleantest.views.fragments.FragmentDataUpdater;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesPresenter {


    private static Retrofit retrofit = null;


    public static Retrofit getClient() {

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



    //FETCH Popular Movies
    public void getPopularMoviesRx(final FragmentDataUpdater fragmentDataUpdater){

        MovieApiService apiService = getClient()
                .create(MovieApiService.class);

        // Fetching popular movies
        apiService.fetchPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("REQUEST SUCCESS","SUCCESS");
                        fragmentDataUpdater.updateRecyclerViewWithNewData(rootResponse.getResults());

                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("REQUEST FAILED","FAILED");
                        fragmentDataUpdater.failedDisplayer();


                    }
                });



    }



    //FETCH Top Rated Movies
    public void getTopRatedMoviesRx(final FragmentDataUpdater fragmentDataUpdater){

        MovieApiService apiService = getClient()
                .create(MovieApiService.class);

        // Fetching top rated movies
        apiService.fetchTopRatedMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("REQUEST SUCCESS","SUCCESS");
                        fragmentDataUpdater.updateRecyclerViewWithNewData(rootResponse.getResults());


                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("REQUEST FAILED","FAILED");
                        fragmentDataUpdater.failedDisplayer();


                    }
                });

    }



    //FETCH Upcoming Movies
    public void getUpcomingMoviesRx(final FragmentDataUpdater fragmentDataUpdater){

        MovieApiService apiService = getClient()
                .create(MovieApiService.class);

        // Fetching upcoming movies
        apiService.fetchUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("REQUEST SUCCESS","SUCCESS");
                        fragmentDataUpdater.updateRecyclerViewWithNewData(rootResponse.getResults());

                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("REQUEST FAILED","FAILED");
                        fragmentDataUpdater.failedDisplayer();


                    }
                });

    }


    //Fetch Movies by Search key
    public void getMovieFromSearchRx(final FragmentDataUpdater fragmentDataUpdater, String movieToBeSearched){

        MovieApiService apiService = getClient()
                .create(MovieApiService.class);

        // Fetching movies from search
        apiService.fetchMoviesBySearch(movieToBeSearched)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("TEST SUCCESS","RETRIEVED");
                        fragmentDataUpdater.updateRecyclerViewWithNewData(rootResponse.getResults());


                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("REQUEST FAILED","FAILED");
                        fragmentDataUpdater.failedDisplayer();


                    }
                });


    }











    public void getTOP_TEST(final FragmentDataUpdater fragmentDataUpdater){

        MovieApiService apiService = getClient()
                .create(MovieApiService.class);

        // Fetching top rated movies
        apiService.fetchTopRatedMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<RootResponse>() {
                    @Override
                    public void onSuccess(RootResponse rootResponse) {
                        // Received all notes
                        Log.d("REQUEST SUCCESS","SUCCESS");
                        fragmentDataUpdater.updateRecyclerViewWithNewData(rootResponse.getResults());

                    }

                    @Override
                    public void onError(Throwable e) {
                        // Network error
                        Log.d("REQUEST FAILED","FAILED");
                        fragmentDataUpdater.failedDisplayer();


                    }
                });

    }





}
