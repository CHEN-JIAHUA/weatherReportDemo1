package com.chenjiahua.myapplicationdemo1.ui.fragment;



import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chenjiahua.myapplicationdemo1.R;
import com.chenjiahua.myapplicationdemo1.base.BaseFragment;
import com.chenjiahua.myapplicationdemo1.model.domain.Provinces;
import com.chenjiahua.myapplicationdemo1.presenter.impl.ProvincePresenterImpl;
import com.chenjiahua.myapplicationdemo1.ui.adapter.ProvinceDataAdapter;
import com.chenjiahua.myapplicationdemo1.utils.LogUtils;
import com.chenjiahua.myapplicationdemo1.view.IProvinceCallBack;

import java.util.List;

import butterknife.BindView;

public class SelecAreaFragment extends BaseFragment implements IProvinceCallBack {


    private ProvincePresenterImpl provincePresenter;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;
    private ProvinceDataAdapter provinceDataAdapter;

//    public static SelecAreaFragment newInstance(Provinces provinces){
//        SelecAreaFragment selecAreaFragment = new SelecAreaFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("provinceId",provinces.getId());
//        bundle.putString("provinceName",provinces.getName());
//        selecAreaFragment.setArguments(bundle);
//        return selecAreaFragment;
//    }


    @Override
    protected int getResId() {
        return R.layout.select_area_view;
    }

    @Override
    protected void initView(View rootView) {
//        super.initView(rootView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = 4;
                outRect.bottom = 4;
            }
        });

//        创建适配器
        provinceDataAdapter = new ProvinceDataAdapter();
//        设置适配器
        recyclerView.setAdapter(provinceDataAdapter);

    }


    @Override
    protected void initPresenter() {
//        super.initPresenter();
        provincePresenter = new ProvincePresenterImpl();
        provincePresenter.registerCallBack(this);

    }

    @Override
    protected void loadProvinceData() {
//        super.loadProvinceData();
        provincePresenter.getProvinceData();        //调用方法获取数据
    }

    @Override
    public void onLoadedProvince(List<Provinces> provinces) {
//        加载的数据就会从这回来
        if(provinceDataAdapter != null){
            provinceDataAdapter.setProvinceData(provinces);
        }
        LogUtils.d(SelecAreaFragment.class,"provinces ==== > " + provinces.toString());
    }

    /**
     * 释放资源
     */
    @Override
    protected void release() {
//        super.release();
        if (provincePresenter != null) {
            provincePresenter.unRegisterCallBack(this);
        }
    }
}
