package com.mp.myapplication.di.module;

import android.app.Application;

import com.mp.myapplication.app.GitHubApplication;
import com.mp.myapplication.di.app.ActivityModule;
import com.mp.myapplication.di.app.AppModule;
import com.mp.myapplication.di.app.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        RxJavaModule.class,
        RetrofitModule.class,
        NetworkModule.class,
        ActivityModule.class,
        FragmentModule.class,
        ViewModelModule.class,
        GitHubRepoModule.class

})
@Singleton
public interface AppComponent {

    void inject(GitHubApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder provideAppContext(Application application);

        AppComponent build();
    }
}