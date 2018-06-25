package com.example.arthursaad.cedroapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.arthursaad.cedroapp.model.Site;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "sites.db";
    private static final int DATABASE_VERSION = 6;
    private Dao<Site, Integer> siteDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Site.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersin, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Site.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        super.close();
    }

    public Dao<Site, Integer> getDao() {
        if (siteDao == null) {
            try {
                siteDao = getDao(Site.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return siteDao;
    }


}
