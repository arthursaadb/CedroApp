package com.example.arthursaad.cedroapp.model;

import android.media.Image;
import android.widget.ImageView;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "sites")
public class Site implements Serializable {
    @DatabaseField(columnName = "id", allowGeneratedIdInsert = true,generatedId = true)
    Integer id;
    @DatabaseField(columnName = "url")
    private String url;
    @DatabaseField(columnName = "login")
    private String user;
    @DatabaseField(columnName = "password")
    private String password;

    public Site(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Site(String url, String user, String password) {
        this.url = url;

        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
