package com.example.postapiexample.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapiexample.R;
import com.example.postapiexample.model.NameResponse;

public class NameViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv;
    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void bind(NameResponse name) {
        nameTv = itemView.findViewById(R.id.textView);
        nameTv.setText(name.getName());
    }
}
