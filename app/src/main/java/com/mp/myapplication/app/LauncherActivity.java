package com.mp.myapplication.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.mp.myapplication.R;
import com.mp.myapplication.searchrepo.ui.GithubSearchActivity;
import com.mp.myapplication.searchrepo.ui.StringUtils;

public class LauncherActivity extends Activity {
    final public static String KEY_USERNAME = "USERNAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        EditText editText = findViewById(R.id.et_username);
        findViewById(R.id.bt_fetch).setOnClickListener(v -> {
            if (StringUtils.isNotEmpty(editText.getText().toString())) {
                Intent intent = new Intent(this, GithubSearchActivity.class);
                intent.putExtra(KEY_USERNAME, editText.getText().toString());
                startActivity(intent);
            }

        });
    }
}
