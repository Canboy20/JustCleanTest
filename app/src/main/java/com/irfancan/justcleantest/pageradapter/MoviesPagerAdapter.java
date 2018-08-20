package com.irfancan.justcleantest.pageradapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.views.fragments.search.SearchMoviesFragment;

public class MoviesPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public MoviesPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {

       //The first three fragments will display a list of movies. The Fourth fragment is for movie search
        if (position == 3) {

            return new SearchMoviesFragment();

        } else {

            MoviesListFragment movieFragment=new MoviesListFragment();
            Bundle bdl = new Bundle(1);
            bdl.putInt("POSITION_OF_FRAGMENT", position);
            movieFragment.setArguments(bdl);
            return movieFragment;

        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.popular_movies);
            case 1:
                return mContext.getString(R.string.top_rated_movies);
            case 2:
                return mContext.getString(R.string.upcoming_movies);
            case 3:
                return mContext.getString(R.string.search_movies);
            default:
                return null;
        }
    }

}