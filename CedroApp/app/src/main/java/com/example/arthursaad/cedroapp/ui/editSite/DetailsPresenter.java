package com.example.arthursaad.cedroapp.ui.editSite;

import android.content.Context;
import android.content.Intent;
import android.util.Patterns;
import android.webkit.URLUtil;

import com.bumptech.glide.Glide;
import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.helper.AksHelper;
import com.example.arthursaad.cedroapp.helper.GliderHelper;
import com.example.arthursaad.cedroapp.helper.HelperSaveToken;
import com.example.arthursaad.cedroapp.helper.SiteDbHelper;
import com.example.arthursaad.cedroapp.model.Site;
import com.example.arthursaad.cedroapp.ui.dialog.CustomDialog;
import com.example.arthursaad.cedroapp.ui.recyclerSites.SitesActivity;
import com.example.arthursaad.cedroapp.ui.registerUser.RegisterUserPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailsPresenter {
    private DetailsActivity mView;
    private SiteDbHelper dbHelper;
    private AksHelper aksHelper;

    public enum VALIDATEDATA{
        CORRECT,
        WRONG
    }

    public DetailsPresenter(DetailsActivity detailsActivity){
        this.mView = detailsActivity;
        dbHelper = new SiteDbHelper(mView);
        aksHelper = new AksHelper(mView);
    }

    public Site getSiteDetails() {
        Site site = (Site) mView.getIntent().getSerializableExtra("SITE_DETAILS");
        return site;
    }


    public String urlSite(){
        String url = (String) mView.getIntent().getSerializableExtra("URL_SITE");
        return url;
    }


    public void loadDetail() {
        Site site = getSiteDetails();
        mView.txtUrl.setText(site.getUrl());
        mView.txtUser.setText(site.getUser());
        mView.txtPassword.setText(site.getPassword());
        Glide.with(mView).load(GliderHelper.getImg(urlSite(), HelperSaveToken.getToken(mView))).into(mView.imageView);
    }

    public void editSite() {
        Site site = getSiteDetails();
        site.setUrl(mView.txtUrl.getText().toString());
        site.setUser(mView.txtUser.getText().toString());
        site.setPassword(aksHelper.encryptText(mView.txtPassword.getText().toString()));
        dbHelper.createOrUpdate(site);
        Intent intent = new Intent(mView, SitesActivity.class);
        mView.startActivity(intent);
    }

    public void deleteSite() {
        dbHelper = new SiteDbHelper(mView);
        dbHelper.delteSiteID(getSiteDetails().getId());
        CustomDialog cdd = new CustomDialog(mView, mView.getString(R.string.deleteSite),SitesActivity.class);
        cdd.show();
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
