package com.liliumproject.android.gitrepapp;

import io.realm.RealmObject;

/**
 * Created by kt on 2017/07/23.
 */

public class Rep extends RealmObject {

    private String title;
    private String url;
    private String content;
    private String date;


    public Rep() {
    }
    public String getTitle(){
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    // getters/setters/etc

}