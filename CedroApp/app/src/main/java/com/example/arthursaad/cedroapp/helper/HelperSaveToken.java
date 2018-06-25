package com.example.arthursaad.cedroapp.helper;

import android.content.Context;
import android.preference.PreferenceManager;

import com.example.arthursaad.cedroapp.model.Token;

public class HelperSaveToken {

    private static final String MYKEY="ACCESSTOKEN";

    public static void saveToken(Token token, Context context){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(MYKEY, token.getToken()).apply();

    }

    public static String getToken(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(MYKEY, null);
    }
}
