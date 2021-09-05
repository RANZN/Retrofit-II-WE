package com.ranzan.retrofit_iiwe;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView name, email, body;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View v) {
        name = v.findViewById(R.id.tvName);
        email = v.findViewById(R.id.tvEmail);
        body = v.findViewById(R.id.tvBody);
    }

    void setData(ResponseItem responseItem) {
        name.setText(responseItem.getName());
        email.setText(responseItem.getEmail());
        body.setText(responseItem.getBody());
    }
}
