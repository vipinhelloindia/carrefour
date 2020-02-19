package com.mp.myapplication.di.app;

import com.mp.myapplication.searchrepo.ui.GithubSearchActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract GithubSearchActivity contributeMainActivity();
}
