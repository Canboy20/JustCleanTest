package com.irfancan.justcleantest.views.fragments.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irfancan.justcleantest.R;

public class SearchMoviesFragment extends Fragment {

    public SearchMoviesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_list, container, false);

        return rootView;
    }

}
