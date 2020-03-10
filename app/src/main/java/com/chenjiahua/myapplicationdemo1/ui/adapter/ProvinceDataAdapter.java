package com.chenjiahua.myapplicationdemo1.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chenjiahua.myapplicationdemo1.R;
import com.chenjiahua.myapplicationdemo1.model.domain.Provinces;
import com.chenjiahua.myapplicationdemo1.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProvinceDataAdapter extends RecyclerView.Adapter<ProvinceDataAdapter.InnerHolder> {

    private List<Provinces> provincesList = new ArrayList<>();
    @NonNull
    @Override
    public ProvinceDataAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_content, parent, false);
        return new InnerHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ProvinceDataAdapter.InnerHolder holder, int position) {
        Provinces provinces = provincesList.get(position);
        LogUtils.d(ProvinceDataAdapter.class,"onBindViewHolder --- provinces  ----> " + provinces.toString());
        holder.setData(provinces);

    }

    @Override
    public int getItemCount() {
        LogUtils.d(ProvinceDataAdapter.class,"ItemCount --- > " + provincesList.size());
        return this.provincesList.size();
    }

    public void setProvinceData(List<Provinces> provinces) {
        provincesList.clear();
        provincesList.addAll(provinces);
        LogUtils.d(ProvinceDataAdapter.class,"provinces === > " + provinces.toString());
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.textView_area)
        public TextView textViewArea;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(Provinces provinces) {
            textViewArea.setText(provinces.getName());
            LogUtils.d(ProvinceDataAdapter.class,"text --->" + provinces.getName());
        }
    }
}
