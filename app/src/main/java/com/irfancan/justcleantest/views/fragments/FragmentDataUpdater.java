package com.irfancan.justcleantest.views.fragments;

import com.irfancan.justcleantest.models.MoviesResponse;

import java.util.List;

public interface FragmentDataUpdater {

    //If the data request is successful, this method will update the data in the recyclerview
    void updateRecyclerViewWithNewData(List<MoviesResponse> newListData);

    //If request fails, this method will be called
    void failedDisplayer();

}
