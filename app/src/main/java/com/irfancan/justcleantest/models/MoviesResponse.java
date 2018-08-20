package com.irfancan.justcleantest.models;

public class MoviesResponse {


    private int voteCount;
    private int id;
    private boolean video;
    private String title;
    private String poster_path;
    private String original_title;
    private String overview;

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
