package com.mp.myapplication.di.module;

import com.mp.myapplication.di.FakeAppNetworkManager;
import com.mp.myapplication.di.network.NetworkManager;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FakeNetworkModule {
    @Binds
    abstract NetworkManager getAppNetworkManager(FakeAppNetworkManager appNetworkManager);
}
