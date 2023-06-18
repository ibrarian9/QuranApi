package com.app.uas_quran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.app.uas_quran.Model.AyatIndo.Combined;
import com.app.uas_quran.Model.AyatIndo.CombinedItem;
import com.app.uas_quran.Retrofit.ApiBase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailSurahActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AyatIndoAdapter ayatIndoAdapter;

    private final List<CombinedItem> list = new ArrayList<>();

    @Override
    protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_surah);

            int id = getIntent().getIntExtra("id", 1);

            setUpView();
            setUpRecyclerView();
            getVersesData(id);
            getTranslateData(id);
        }

    private void getTranslateData(int id) {
            ApiBase.endpoint().getIndo(id).enqueue(new Callback<Combined>() {
                @Override
                public void onResponse(@NonNull Call<Combined> call, @NonNull Response<Combined> response) {
                    if (response.isSuccessful()){
                        assert response.body() != null;
                        List<CombinedItem> result = response.body().getTranslations();
                        Log.d("Ayat" , toString());
                        ayatIndoAdapter.setData(result);
                    }
                }
                @Override
                public void onFailure(@NonNull Call<Combined> call, @NonNull Throwable t) {
                }
            });
        }
    private void getVersesData (int id){
        ApiBase.endpoint().getAyat(id).enqueue(new Callback<Combined>() {
            @Override
            public void onResponse(@NonNull Call<Combined> call, @NonNull Response<Combined> response) {
                assert response.body() != null;
                List<CombinedItem> result = response.body().getVerses();
                Log.d("Ayat", toString());
                ayatIndoAdapter.setData(result);
            }
            @Override
            public void onFailure(@NonNull Call<Combined> call, @NonNull Throwable t) {
            }
        });
    }
    private void setUpRecyclerView () {

        ayatIndoAdapter = new AyatIndoAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(ayatIndoAdapter);
    }
    private void setUpView () {
        recyclerView = findViewById(R.id.rvAyat);
    }
}

