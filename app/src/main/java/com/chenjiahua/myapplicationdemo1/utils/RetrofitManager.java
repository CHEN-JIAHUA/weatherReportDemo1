package com.chenjiahua.myapplicationdemo1.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static final RetrofitManager INSTANCE = new RetrofitManager();
    private final Retrofit mRetrofit;


    public RetrofitManager() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitManager getINSTANCE() {
        return INSTANCE;
    }

    public Retrofit getmRetrofit() {
        return mRetrofit;
    }
}
