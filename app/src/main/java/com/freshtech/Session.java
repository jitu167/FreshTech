package com.freshtech;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by KUSUM DEVI on 15-05-2016.
 */
public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusename(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","");
        return usename;
    }
    public void setPhone(String Phone) {
        prefs.edit().putString("edittext",Phone).commit();
    }

    public String getPhone() {
        String usename = prefs.getString("edittext","");
        return usename;
    }
    public boolean containsUser(String user)
    {
        return prefs.contains(user);
    }
    public void logout()
    {
        prefs.edit().clear().commit();
    }

}
