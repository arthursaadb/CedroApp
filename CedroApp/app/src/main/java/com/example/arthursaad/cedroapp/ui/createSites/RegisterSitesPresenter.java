package com.example.arthursaad.cedroapp.ui.createSites;

import android.util.Log;
import android.util.Patterns;

import com.example.arthursaad.cedroapp.helper.AksHelper;
import com.example.arthursaad.cedroapp.helper.SiteDbHelper;
import com.example.arthursaad.cedroapp.model.Site;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterSitesPresenter {
    RegisterSitesActivity mView;
    private Site site;
    SiteDbHelper dbHelper;
    private AksHelper aksHelper;
    public void setView(RegisterSitesActivity view) {
        this.mView = view;
    }

    public void addData(String url, String login, String password) throws SQLException {
        dbHelper = new SiteDbHelper(mView);
        aksHelper = new AksHelper(mView);
        site = new Site(url,login,password);
        site.setPassword(aksHelper.encryptText(password));
        dbHelper.createOrUpdate(site);
    }

    public boolean isValidUrl(String url){
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(url.toLowerCase());
        if(m.matches()){
            return true;
        }
        else
            return false;
    }

}
