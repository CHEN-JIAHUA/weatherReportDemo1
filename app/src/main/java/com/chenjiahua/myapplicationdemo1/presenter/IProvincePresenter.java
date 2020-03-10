package com.chenjiahua.myapplicationdemo1.presenter;

import com.chenjiahua.myapplicationdemo1.view.IProvinceCallBack;

public interface IProvincePresenter {

    //获取省份数据
    void getProvinceData();

    /**
     * 注册UI通知的接口
     * @param callBack
     */
    void registerCallBack(IProvinceCallBack callBack);

    /**
     * 注销UI通知的接口
     * @param callBack
     */
    void unRegisterCallBack(IProvinceCallBack callBack);
}
