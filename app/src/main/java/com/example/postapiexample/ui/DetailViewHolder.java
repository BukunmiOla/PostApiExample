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
        detailTv = itemView.findViewById(R.id.detail_tv);
        nameTv.setText(name.getName());
        String detail = "Address: " + name.getAddress().toString() +
                "\nEmail: " + name.getEmail().toString() +
                "\nPhone number: " + name.getPhoneNumber().toString() +
                "\nGender: " + name.getGender().toString();

        detailTv.setText(detail);
    }
}
