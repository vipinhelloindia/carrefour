package com.mp.myapplication.searchrepo;

import androidx.annotation.MainThread;

public interface NetworkAwareRepo {
    @MainThread
    boolean shouldFetch();
}
