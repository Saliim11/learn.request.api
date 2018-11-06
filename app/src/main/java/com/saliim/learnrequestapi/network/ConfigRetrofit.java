package com.saliim.learnrequestapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static final String BASE_URL = "http://192.168.95.104/portal_berita-master/";

    public static final String IMAGES = BASE_URL+"images/";

    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInsteance(){
        return setInit().create(ApiService.class);
    }
}
