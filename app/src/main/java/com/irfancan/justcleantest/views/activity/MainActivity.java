package com.irfancan.justcleantest.views.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.irfancan.justcleantest.R;
import com.irfancan.justcleantest.pageradapter.MoviesPagerAdapter;
import com.irfancan.justcleantest.presenters.MoviesPresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    //ViewPager
    ViewPager viewPager;

    //Presenter
    @Inject
    MoviesPresenter moviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        //Presenter is responsible in retrieving data from model and sending it to the UI ( Used to follow MVP design approach )
        //Dagger will automatically create 'MoviesPresenter'. No need for 'moviesPresenter=new MoviesPresenter();'
        AndroidInjection.inject(this);
        //moviesPresenter=new MoviesPresenter();

        //Initializes ViewPager
        viewPager=findViewById(R.id.moviesViewPager);
        viewPager.setAdapter(new MoviesPagerAdapter(this,getSupportFragmentManager()));

        // Adds TabLayout to the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }



    //Fragments will use this method to retrieve reference of Presenter
    public MoviesPresenter getMoviesPresenter() {

        return moviesPresenter;

    }
}
