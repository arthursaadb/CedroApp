package com.example.arthursaad.cedroapp.service;

public interface ResponseListener<T> {
    void callbackSucessResponse(T response);
    void callbackFailureResponse(String error);
}
