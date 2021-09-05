package com.ranzan.retrofit_iiwe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ResponseItem> list;

    public Adapter(List<ResponseItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponseItem responseItem = list.get(position);
        holder.setData(responseItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void updateUi(List<ResponseItem> responseItems) {
        list = responseItems;
        notifyDataSetChanged();
    }
}
