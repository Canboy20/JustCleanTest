package com.irfancan.justcleantest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.irfancan.justcleantest.pageradapter.MoviesPagerAdapter;
import com.irfancan.justcleantest.presenters.MoviesPresenter;

public class MainActivity extends AppCompatActivity {

    //ViewPager
    ViewPager viewPager;

    //Presenter
    MoviesPresenter moviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Presenter is responsible in retrieving data from model and sending it to the UI ( Used to follow MVP design approach )
        moviesPresenter=new MoviesPresenter();

        //Initializes ViewPager
        viewPager=findViewById(R.id.moviesViewPager);
        viewPager.setAdapter(new MoviesPagerAdapter(this,getSupportFragmentManager()));

        // Adds TabLayout to the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }



    //Fragments will use this method to retrieve ref of Presenter
    public MoviesPresenter getMoviesPresenter() {
        return moviesPresenter;
    }
}
