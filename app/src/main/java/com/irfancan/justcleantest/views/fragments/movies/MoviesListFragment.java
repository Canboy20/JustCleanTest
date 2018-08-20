package com.irfancan.justcleantest.views.fragments.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.MoviesResponse;
import com.irfancan.justcleantest.models.RootResponse;
import com.irfancan.justcleantest.views.fragments.movies.adapter.MoviesAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoviesListFragment extends Fragment {


    //RecyclerView Parameters
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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

        //Just to check if I can get the data
        testPopularMoviesRequest();

    }





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





}
