package com.example.arthursaad.cedroapp.service;

import android.content.Context;

import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.model.Token;
import com.example.arthursaad.cedroapp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    NetworkRequest request = new NetworkRequest();
    final Retrofit retrofit = request.doConection();

    public void doRegister(User user,
                           final Context context,
                           final ResponseListener<Token> listener) {

        UserClient client = retrofit.create(UserClient.class);
        Call<Token> call = client.createAccount(user);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call,
                                   Response<Token> response) {
                if (response.isSuccessful() &&
                        response.body() != null) {
                    listener.callbackSucessResponse(response.body());

                } else {
                    listener.callbackFailureResponse(context.getString(R.string.request_error));
                }

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        });

    }

    public void doLogin(User user,
                        final Context context,
                        final ResponseListener<Token> listener) {
        UserClient client = retrofit.create(UserClient.class);
        Call<Token> call = client.doLogin(user);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful() &&
                        response.body() != null) {
                    listener.callbackSucessResponse(response.body());
                }
                else
                    listener.callbackFailureResponse(context.getString(R.string.request_error));

            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        });
    }
}
