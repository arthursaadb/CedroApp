package com.example.arthursaad.cedroapp.DAO;

import com.example.arthursaad.cedroapp.model.Site;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class SitesDAO extends BaseDaoImpl<Site,Integer> {

    public SitesDAO(ConnectionSource connectionSource) throws SQLException {
        super(Site.class);
        setConnectionSource(connectionSource);
        initialize();
    }
}
