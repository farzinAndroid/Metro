package com.farzin.metro.model;

import com.google.gson.annotations.SerializedName;

public class Lines {

    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("EnglishTitle")
    String englishTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }
}
