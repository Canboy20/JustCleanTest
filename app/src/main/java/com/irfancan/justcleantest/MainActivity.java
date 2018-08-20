package com.irfancan.justcleantest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.irfancan.justcleantest.pageradapter.MoviesPagerAdapter;

public class MainActivity extends AppCompatActivity {

    //ViewPager
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializes ViewPager
        viewPager=findViewById(R.id.moviesViewPager);
        viewPager.setAdapter(new MoviesPagerAdapter(this,getSupportFragmentManager()));

        // Adds TabLayout to the ViewPager
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}
