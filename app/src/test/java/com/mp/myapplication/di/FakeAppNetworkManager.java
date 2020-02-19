package com.mp.myapplication.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import com.mp.myapplication.di.app.ApplicationContext;
import com.mp.myapplication.di.network.NetworkManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FakeAppNetworkManager implements NetworkManager {

    private Context context;

    @Inject
    public FakeAppNetworkManager() {

    }

    @SuppressWarnings("deprecation")
    @Override
    public String connectionType() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo != null) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return "WIFI";
            }

            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return "MOBILE";
            }
        }
        return "OFFLINE";
    }

    @Override
    public boolean isOnline() {
        return false;
    }
}
