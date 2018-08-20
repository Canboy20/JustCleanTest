package com.irfancan.justcleantest;

import com.irfancan.justcleantest.views.activity.MainActivity;
import com.irfancan.justcleantest.views.activity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ApplicationBaseModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();
}
