package com.saliim.learnrequestapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.saliim.learnrequestapi.adapter.AdapterBerita;
import com.saliim.learnrequestapi.model.BeritaItem;
import com.saliim.learnrequestapi.model.ResponseBerita;
import com.saliim.learnrequestapi.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.saliim.learnrequestapi.network.ConfigRetrofit.getInsteance;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.recylerview);

        list.setLayoutManager(new LinearLayoutManager(this));

        getData();

    }

    private void getData() {
        ApiService apiService = getInsteance();
        retrofit2.Call<ResponseBerita> call = apiService.getDataBerita();
        call.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                Log.d(getString(R.string.response), getString(R.string.success) + response.body().toString());
                List<BeritaItem> beritaItem = response.body().getBerita();
                boolean status = response.body().isStatus();

                if (status){
                    Log.d(getString(R.string.data_berita), beritaItem.toString());

                    AdapterBerita adapter = new AdapterBerita(MainActivity.this, beritaItem);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });
    }
}
