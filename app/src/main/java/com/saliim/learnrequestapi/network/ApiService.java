package com.saliim.learnrequestapi.network;

import com.saliim.learnrequestapi.model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //TODO : cara request
    @GET("tampil_berita.php")
    Call<ResponseBerita> getDataBerita();
}
