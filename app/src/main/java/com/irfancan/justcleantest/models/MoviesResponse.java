package com.irfancan.justcleantest.models;

public class MoviesResponse {


    int voteCount;
    int id;
    boolean video;
    String title;
    String poster_path;
    String original_title;
    String overview;

    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setTitle(String titleRecv) {
        title=titleRecv;
    }

}
