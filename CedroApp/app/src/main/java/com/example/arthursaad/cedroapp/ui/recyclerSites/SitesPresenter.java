package com.example.arthursaad.cedroapp.ui.recyclerSites;

import com.example.arthursaad.cedroapp.helper.SiteDbHelper;
import com.example.arthursaad.cedroapp.model.Site;

import java.util.ArrayList;
import java.util.List;

public class SitesPresenter {
    SitesActivity mView;
    SiteDbHelper dbHelper;


    public SitesPresenter(SitesActivity view) {
        this.mView = view;
    }

    public List<Site> recoverSites() {
        List<Site> sitesList = null;
        dbHelper = new SiteDbHelper(mView);
        sitesList = dbHelper.getallSites();
        return sitesList;
    }
}
