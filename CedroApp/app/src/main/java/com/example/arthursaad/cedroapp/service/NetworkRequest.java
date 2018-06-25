package com.example.arthursaad.cedroapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRequest {

    public Retrofit doConection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev.people.com.ai/mobile/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
