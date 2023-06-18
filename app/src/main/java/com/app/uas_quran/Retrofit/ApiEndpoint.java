package com.app.uas_quran.Retrofit;

import com.app.uas_quran.Model.AyatIndo.Combined;
import com.app.uas_quran.Model.SurahModel.Chapters;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {
    @GET("chapters?language=id")
    Call<Chapters> getSurah();
    @GET("quran/verses/uthmani?")
    Call<Combined> getAyat (@Query("chapter_number") int id);
    @GET("quran/translations/33?")
    Call<Combined> getIndo (@Query("chapter_number") int id);
}
