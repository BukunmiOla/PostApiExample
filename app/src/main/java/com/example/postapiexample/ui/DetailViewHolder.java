package com.example.postapiexample.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapiexample.R;
import com.example.postapiexample.model.DetailResponse;

public class DetailViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv;
    ConstraintLayout bodyCl;
    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv = itemView.findViewById(R.id.name_tv);
        bodyCl = itemView.findViewById(R.id.body_cl);

    }


    public void bind(DetailResponse name, NameSelectionListener listener) {
        nameTv.setText(name.getName());
        bodyCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSelectName(name);
            }
        });
    }
}
