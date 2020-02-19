package com.mp.myapplication.di.module;
import com.mp.myapplication.di.network.AppNetworkManager;
import com.mp.myapplication.di.network.NetworkManager;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NetworkModule {
    @Binds
    abstract NetworkManager getAppNetworkManager(AppNetworkManager appNetworkManager);
}
