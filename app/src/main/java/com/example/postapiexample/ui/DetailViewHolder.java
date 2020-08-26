package com.example.postapiexample.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapiexample.R;
import com.example.postapiexample.model.DetailResponse;

public class DetailViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv, detailTv;
    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void bind(DetailResponse name) {
        nameTv = itemView.findViewById(R.id.name_tv);
        nameTv.setText(name.getName());
    }
}
