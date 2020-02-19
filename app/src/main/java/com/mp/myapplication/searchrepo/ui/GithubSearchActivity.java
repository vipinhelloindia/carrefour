package com.mp.myapplication.searchrepo.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.mp.myapplication.R;
import com.mp.myapplication.app.LauncherActivity;
import com.mp.myapplication.base.BaseAppCompactActivity;

public class GithubSearchActivity extends BaseAppCompactActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SearchListingFragment
                            .newInstance(getIntent().getStringExtra(LauncherActivity.KEY_USERNAME)))
                    .commitNow();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStackImmediate();
        else super.onBackPressed();
    }
}
