package com.example.arthursaad.cedroapp.service;

import com.example.arthursaad.cedroapp.model.Token;
import com.example.arthursaad.cedroapp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserClient {
    @POST("register")
    Call<Token> createAccount(@Body User user);

    @POST("login")
    Call<Token> doLogin(@Body User user);
}
