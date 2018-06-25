package com.example.arthursaad.cedroapp.helper;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.example.arthursaad.cedroapp.aks.AKSEncryptor;

public class AksHelper {

    private static AKSEncryptor encryptionHelper;
    private final String SAMPLE_ALIAS = "CEDROSENHAS";


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public AksHelper(Context context){
        encryptionHelper = new AKSEncryptor(context,SAMPLE_ALIAS);
    }

    public String encryptText(String text)  {
        return encryptionHelper.encryptString(text,SAMPLE_ALIAS);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String decryptText(String text) {
        return encryptionHelper.decryptString(text,SAMPLE_ALIAS);
    }

}
