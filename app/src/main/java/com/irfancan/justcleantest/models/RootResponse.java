package com.irfancan.justcleantest.models;


import java.util.List;

public class RootResponse {


    int page;
    int total_results;
    int total_pages;
    List<MoviesResponse> results;


    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<MoviesResponse> getResults() {
        return results;
    }
}

