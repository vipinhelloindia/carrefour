package com.mp.myapplication.di.module;


import androidx.lifecycle.ViewModel;

import com.mp.myapplication.di.factory.ViewModelKey;
import com.mp.myapplication.searchrepo.GitHubSearchRepository;
import com.mp.myapplication.searchrepo.GitHubSearchRepositoryImpl;
import com.mp.myapplication.searchrepo.SearchRepoViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

;

@Module
public abstract class GitHubRepoModule {
    @Binds
    abstract GitHubSearchRepository getSearchRepository(GitHubSearchRepositoryImpl gitHubSearchRepository);

    @Binds
    @IntoMap
    @ViewModelKey(SearchRepoViewModel.class)
    protected abstract ViewModel requestSearchRepoModel(SearchRepoViewModel searchRepoViewModel);
}
