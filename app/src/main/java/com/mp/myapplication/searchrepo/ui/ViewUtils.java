package com.mp.myapplication.searchrepo.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ViewUtils {

    public static void setTextView(@NonNull TextView textView, String text) {
        if (!StringUtils.isEmpty(text)) {
            textView.setText(text);
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
    }
}
