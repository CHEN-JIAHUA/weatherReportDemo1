package com.chenjiahua.myapplicationdemo1.model;


import com.chenjiahua.myapplicationdemo1.model.domain.Provinces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("china")
    Call<List<Provinces>> getProvinces();


}
