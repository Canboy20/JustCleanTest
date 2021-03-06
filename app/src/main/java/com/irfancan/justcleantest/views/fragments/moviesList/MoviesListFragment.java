package com.irfancan.justcleantest.views.fragments.moviesList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.irfancan.justcleantest.views.activity.MainActivity;
import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.MoviesResponse;
import com.irfancan.justcleantest.models.RootResponse;
import com.irfancan.justcleantest.views.fragments.FragmentDataUpdater;
import com.irfancan.justcleantest.views.fragments.moviesList.adapter.MoviesAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoviesListFragment extends Fragment implements FragmentDataUpdater {


    //RecyclerView Parameters
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //ProgressBar
    ProgressBar progressBar;


    //Holds the movies that will be displayed on the list
    List<MoviesResponse> moviesResponses=new ArrayList<>();

    //Position of fragment
    private int positionOfFragment=0;




    public MoviesListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movies_list, container, false);

        mRecyclerView=rootView.findViewById(R.id.movies_recycler_view);

        progressBar=rootView.findViewById(R.id.progressBar);

        // Linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Adapter Recyclerview will use
        mAdapter = new MoviesAdapter(moviesResponses);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }



    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //This will return us an integer number, representing index of fragment
        //With this index, we will know which request to make (POPULAR / TOPRATED / UPCOMING requests)
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            positionOfFragment = bundle.getInt(Constants.FRAGMENT_POSITION);
        }


        //Makes request according to the index of the fragment
        //Fragment 0  -> Displays Popular Movies
        //Fragment 1  -> Displays Top Rated Movies
        //Fragment 2  -> Displays Upcoming Movies
        retrieveData(positionOfFragment);


    }



    //
    private void retrieveData(int positionOfThisFragment){


        progressBar.setVisibility(View.VISIBLE);


        if(positionOfThisFragment==0){

            //RXJava Version
            ((MainActivity)getActivity()).getMoviesPresenter().getPopularMoviesRx(this);

            //VOLLEY Version
            //testPopularMoviesRequest();

        }else if(positionOfThisFragment==1){

            //RXJava Version
            ((MainActivity)getActivity()).getMoviesPresenter().getTopRatedMoviesRx(this);


            //VOLLEY Version
            //testTopRated();

        }else if(positionOfThisFragment==2){

            //RXJava Version
            ((MainActivity)getActivity()).getMoviesPresenter().getUpcomingMoviesRx(this);

            //VOLLEY Version
            //testUpcoming();

        }


    }





    //The methods below fetch the data using Volley. Used it for testing purpose during the early stages of the project.

    private void testPopularMoviesRequest(){


        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="https://api.themoviedb.org/3/movie/popular?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new GsonBuilder().create();
                        RootResponse boxOfficeMovieResponse = gson.fromJson(String.valueOf(response), RootResponse.class);

                        moviesResponses.clear();
                        moviesResponses.addAll(boxOfficeMovieResponse.getResults());

                        mAdapter.notifyDataSetChanged();



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                        //Too bad :(

                    }
                });

        queue.add(jsonObjectRequest);

    }




    private void testTopRated(){


        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="https://api.themoviedb.org/3/movie/top_rated?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new GsonBuilder().create();
                        RootResponse boxOfficeMovieResponse = gson.fromJson(String.valueOf(response), RootResponse.class);

                        moviesResponses.clear();
                        moviesResponses.addAll(boxOfficeMovieResponse.getResults());

                        mAdapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);

    }





    private void testUpcoming(){


        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="https://api.themoviedb.org/3/movie/upcoming?api_key=a22e4f0e19562d452bb0faabc3c925c9&language=en-US&page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new GsonBuilder().create();
                        RootResponse boxOfficeMovieResponse = gson.fromJson(String.valueOf(response), RootResponse.class);


                        moviesResponses.clear();
                        moviesResponses.addAll(boxOfficeMovieResponse.getResults());

                        mAdapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        queue.add(jsonObjectRequest);

    }





    //IMPORTANT!! These methods below will be called after the fetch request.
    @Override
    public void updateRecyclerViewWithNewData(List<MoviesResponse> newListData) {

        progressBar.setVisibility(View.GONE);

        //Update RecyclerView with new Data
        moviesResponses.clear();
        moviesResponses.addAll(newListData);

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void failedDisplayer() {

        Log.e("FAILED","Failed to fetch data");
        progressBar.setVisibility(View.GONE);

    }
}
