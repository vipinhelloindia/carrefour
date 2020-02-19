package com.mp.myapplication.di.component;



import com.mp.myapplication.SearchRepoViewModelTest;
import com.mp.myapplication.di.app.AppModule;
import com.mp.myapplication.di.module.FakeNetworkModule;
import com.mp.myapplication.di.module.GitHubRepoModule;
import com.mp.myapplication.di.module.NetworkModule;
import com.mp.myapplication.di.module.RetrofitModule;
import com.mp.myapplication.di.module.RxJavaTestModule;
import com.mp.myapplication.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Reusable;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, RetrofitModule.class,
        FakeNetworkModule.class, GitHubRepoModule.class, RxJavaTestModule.class, ViewModelModule.class})
public interface TestComponent {

    @Reusable
    void inject(SearchRepoViewModelTest test);

    @Component.Builder
    interface Builder {
        TestComponent build();
    }
}