package com.example.studyshare.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    public static void setUser(Context c, int id, String role) {
        SharedPreferences sp = c.getSharedPreferences("session", Context.MODE_PRIVATE);
        sp.edit()
                .putInt("id", id)
                .putString("role", role)
                .apply();
    }

    public static int getUserId(Context c) {
        return c.getSharedPreferences("session", Context.MODE_PRIVATE)
                .getInt("id", -1);
    }

    public static boolean isModerator(Context c) {
        return "MODERATOR".equals(
                c.getSharedPreferences("session", Context.MODE_PRIVATE)
                        .getString("role", "USER"));
    }
}
