package com.irfancan.justcleantest.views.fragments.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfancan.justcleantest.R;

public class MoviesListFragment extends Fragment {

    public MoviesListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.movies_list, container, false);

        return rootView;
    }

}
