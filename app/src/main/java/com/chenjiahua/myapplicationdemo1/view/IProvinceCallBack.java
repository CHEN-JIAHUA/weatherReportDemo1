package com.chenjiahua.myapplicationdemo1.view;

import com.chenjiahua.myapplicationdemo1.model.domain.Provinces;

import java.util.List;

public interface IProvinceCallBack {
    //通知UI更新数据
    void onLoadedProvince(List<Provinces> provinces);
}
