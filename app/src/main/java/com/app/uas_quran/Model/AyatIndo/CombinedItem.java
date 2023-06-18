package com.app.uas_quran.Model.AyatIndo;

import com.google.gson.annotations.SerializedName;

public class CombinedItem {
    @SerializedName("resource_id")
    private int resourceId;
    @SerializedName("text")
    private String text;
    @SerializedName("verse_key")
    private String verseKey;
    @SerializedName("text_uthmani")
    private String textUthmani;
    @SerializedName("id")
    private int id;

    public String getVerseKey(){
        return verseKey;
    }
    public String getTextUthmani(){
        return textUthmani;
    }

    public int getId(){
        return id;
    }

    public int getResourceId(){
        return resourceId;
    }
    public String getText(){
        return text;
    }
}
