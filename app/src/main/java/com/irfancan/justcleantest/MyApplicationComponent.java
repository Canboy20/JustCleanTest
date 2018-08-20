package com.irfancan.justcleantest;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = { AndroidInjectionModule.class, ApplicationBaseModule.class})
public interface MyApplicationComponent extends AndroidInjector<ApplicationBase> {
}