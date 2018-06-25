package com.example.arthursaad.cedroapp.helper;

import android.content.Context;
import android.util.Log;

import com.example.arthursaad.cedroapp.DAO.SitesDAO;
import com.example.arthursaad.cedroapp.model.Site;

import java.sql.SQLException;
import java.util.List;

public class SiteDbHelper {
    DatabaseHelper dbhelper;

    public SiteDbHelper(Context context){
        dbhelper = new DatabaseHelper(context);
    }


    public void createOrUpdate(Site site) {
        try {
            dbhelper.getDao().createOrUpdate(site);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delteSiteID(int id){
        try {
            dbhelper.getDao().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Site> getallSites(){
        List<Site> sitesList = null;
        try {
            sitesList = dbhelper.getDao().queryBuilder().orderBy("id",false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sitesList;
    }
}
