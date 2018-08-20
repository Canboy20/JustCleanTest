package com.irfancan.justcleantest.views.fragments.detailsList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.constants.Constants;
import com.irfancan.justcleantest.models.MoviesResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsFragment extends Fragment {

    //Views
    TextView titleOfMovieTextView;
    TextView releaseDateTextView;
    TextView descriptionOfMovieTextView;
    ImageView moviePosterImageView;
    TextView languageTextView;
    TextView ratingextView;



    //Variables
    //Views
    String movieTitle;
    String movieReleaseDate;
    String movieDescription;
    String moviePosterURL;
    String movieLanguage;
    String movieRating;




    public MovieDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movie_details, container, false);

        titleOfMovieTextView=rootView.findViewById(R.id.titleOfMovieTextView);
        releaseDateTextView=rootView.findViewById(R.id.releaseDateTextView);
        descriptionOfMovieTextView=rootView.findViewById(R.id.descriptionOfMovieTextView);
        moviePosterImageView=rootView.findViewById(R.id.moviePosterImageView);
        languageTextView=rootView.findViewById(R.id.languageTextView);
        ratingextView=rootView.findViewById(R.id.ratingTextView);



        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Data retrieved from bundle will update views
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            movieTitle = bundle.getString(Constants.MOVIE_TITLE);
            movieReleaseDate = bundle.getString(Constants.MOVIE_RELEASE_DATE);
            movieDescription = bundle.getString(Constants.MOVIE_PLOT);
            moviePosterURL = bundle.getString(Constants.MOVIE_POSTER_URL);
            movieLanguage=bundle.getString(Constants.MOVIE_LANGUAGE);
            movieRating=bundle.getString(Constants.MOVIE_RATING);



            titleOfMovieTextView.setText(movieTitle);
            releaseDateTextView.setText("Released: " +movieReleaseDate);
            descriptionOfMovieTextView.setText(movieDescription);
            languageTextView.setText("Language: "+movieLanguage);
            ratingextView.setText(movieRating);


            Picasso.get().load(Constants.IMG_BASE_URL + moviePosterURL).into(moviePosterImageView);
        }



    }


}
