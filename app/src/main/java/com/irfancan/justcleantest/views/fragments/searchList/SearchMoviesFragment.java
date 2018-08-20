package com.irfancan.justcleantest.views.fragments.searchList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

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
import com.irfancan.justcleantest.views.activity.MainActivity;
import com.irfancan.justcleantest.views.fragments.FragmentDataUpdater;
import com.irfancan.justcleantest.views.fragments.moviesList.adapter.MoviesAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchMoviesFragment extends Fragment implements FragmentDataUpdater {


    //RecyclerView Parameters
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //FrameLayouts
    private FrameLayout searchMovieFrameLayout;
    private FrameLayout listMoviesFrameLayout;

    //Buttons
    private Button searchButton;
    private Button searchOtherMoviesButton;

    //ProgressBar
    private ProgressBar progressBar;


    //EditText
    private EditText enteredMovieEditText;



    //Holds the movies that will be displayed on the list
    List<MoviesResponse> moviesResponses=new ArrayList<>();



    public SearchMoviesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_list, container, false);

        mRecyclerView=rootView.findViewById(R.id.movies_recycler_view);

        progressBar=rootView.findViewById(R.id.progressBarSearch);
        progressBar.setVisibility(View.GONE);

        //FrameLayouts
        searchMovieFrameLayout=rootView.findViewById(R.id.enterMovieFrameLayout);
        searchMovieFrameLayout.setVisibility(View.VISIBLE);

        listMoviesFrameLayout=rootView.findViewById(R.id.moviesListFrameLayout);
        listMoviesFrameLayout.setVisibility(View.GONE);

        //EditText
        enteredMovieEditText=rootView.findViewById(R.id.enteredMovieEditText);

        //Buttons
        searchButton=rootView.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String typedText= enteredMovieEditText.getText().toString();
                if(typedText.length()>3){
                    enteredMovieEditText.setText("");
                    searchMovieFrameLayout.setVisibility(View.GONE);
                    fetchMoviesBySearch(typedText);

                }

            }
        });


        searchOtherMoviesButton=rootView.findViewById(R.id.searchOtherMoviesButton);
        searchOtherMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listMoviesFrameLayout.setVisibility(View.GONE);
                searchMovieFrameLayout.setVisibility(View.VISIBLE);

            }
        });



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

    }




    private void fetchMoviesBySearch(String movieToBeSearched){


        progressBar.setVisibility(View.VISIBLE);


        //Fetch movies according to what user typed
        ((MainActivity)getActivity()).getMoviesPresenter().getMovieFromSearchRx(this ,movieToBeSearched);

    }





    @Override
    public void updateRecyclerViewWithNewData(List<MoviesResponse> newListData) {

        progressBar.setVisibility(View.GONE);


        //Enable the frameLayout which displays list
        listMoviesFrameLayout.setVisibility(View.VISIBLE);
        searchMovieFrameLayout.setVisibility(View.GONE);


        //Update RecyclerView with new Data
        moviesResponses.clear();
        moviesResponses.addAll(newListData);

        mAdapter.notifyDataSetChanged();



    }

    @Override
    public void failedDisplayer() {


        progressBar.setVisibility(View.GONE);

        //Enable the frameLayout which displays search EditText
        listMoviesFrameLayout.setVisibility(View.GONE);
        searchMovieFrameLayout.setVisibility(View.VISIBLE);


    }
}
