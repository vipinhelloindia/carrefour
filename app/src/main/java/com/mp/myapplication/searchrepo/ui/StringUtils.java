package com.mp.myapplication.searchrepo.ui;


import androidx.annotation.Nullable;

public class StringUtils {

    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * {@hide}
     */
    public static String nullIfEmpty(@Nullable String str) {
        return isEmpty(str) ? null : str;
    }

    /**
     * {@hide}
     */
    public static String emptyIfNull(@Nullable String str) {
        return str == null ? "" : str;
    }

    public static boolean isNotEmpty(String avatarUrl) {
        return !isEmpty(avatarUrl);
    }
}
