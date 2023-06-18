package com.app.uas_quran.Model.AyatIndo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Combined {

    @SerializedName("verses")
    private List<CombinedItem> verses;

    @SerializedName("translations")
    private List<CombinedItem> translations;

    private List<CombinedItem> mergedList;

    public void setMergedList(List<CombinedItem> verses, List<CombinedItem> translations, List<CombinedItem> mergedList ) {
        mergedList = new ArrayList<>();
        mergedList.addAll(verses);
        mergedList.addAll(translations);
    }

    public void setVerses(List<CombinedItem> verses) {
        this.verses = verses;
    }

    public void setTranslations(List<CombinedItem> translations) {
        this.translations = translations;
    }

    public List<CombinedItem> getMergedList() {
        return mergedList;
    }
    public List<CombinedItem> getTranslations(){
        return translations;
    }
    public List<CombinedItem> getVerses(){
        return verses;
    }


}
