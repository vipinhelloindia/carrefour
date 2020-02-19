package com.mp.myapplication.di.app;


import com.mp.myapplication.di.module.GitHubRepoModule;
import com.mp.myapplication.searchrepo.ui.SearchListingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector(modules = GitHubRepoModule.class)
    abstract SearchListingFragment contributeMainFragment();
}
