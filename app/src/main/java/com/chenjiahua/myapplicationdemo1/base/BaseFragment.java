package com.chenjiahua.myapplicationdemo1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = loadRootView(inflater, container);
        ButterKnife.bind(this,rootView);
        initView(rootView);
        initPresenter();
        loadProvinceData();


        return rootView;
    }

    protected void initView(View rootView){

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        release();
    }

    protected void release() {
//        释放资源
    }

    private View loadRootView(LayoutInflater inflater, ViewGroup container) {
        int resId = getResId();
        View view = inflater.inflate(resId, container, false);
        return view;
    }
    //抽象方法是继承了之后一定得实现的方法，但是我们不是每一个都得加载省份数据吧 所以空实现就好
    protected void loadProvinceData() {

    }

    protected abstract int getResId();
    protected  void initPresenter(){
//    创建presenter
    }
}
