package com.chenjiahua.myapplicationdemo1.presenter.impl;

import com.chenjiahua.myapplicationdemo1.model.API;
import com.chenjiahua.myapplicationdemo1.model.domain.Provinces;
import com.chenjiahua.myapplicationdemo1.presenter.IProvincePresenter;
import com.chenjiahua.myapplicationdemo1.utils.LogUtils;
import com.chenjiahua.myapplicationdemo1.view.IProvinceCallBack;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProvincePresenterImpl implements IProvincePresenter {

    private static String provinceUrl = "http://www.guolin.tech/api/";
    private IProvinceCallBack callBack;

    @Override
    public void getProvinceData() {
        //加载省份数据

//        Retrofit retrofit = RetrofitManager.getINSTANCE().getmRetrofit();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(provinceUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        api.getProvinces().enqueue(new Callback<List<Provinces>>() {
            @Override
            public void onResponse(Call<List<Provinces>> call, Response<List<Provinces>> response) {
                int responseCode = response.code();
                LogUtils.d(ProvincePresenterImpl.class,"responseCode === > " + responseCode);
                if(responseCode == HttpURLConnection.HTTP_OK){
                    List<Provinces> provincesData = response.body();
                    LogUtils.d(ProvincePresenterImpl.class,"result =====> " + provincesData.toString());

                    callBack.onLoadedProvince(provincesData);
                }
            }

            @Override
            public void onFailure(Call<List<Provinces>> call, Throwable t) {
                LogUtils.d(ProvincePresenterImpl.class,"OnFailure === > " + t.toString());
            }
        });
    }

    @Override
    public void registerCallBack(IProvinceCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void unRegisterCallBack(IProvinceCallBack callBack) {
        if (callBack != null) {
            this.callBack = null;
        }
    }
}
