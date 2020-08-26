package com.example.postapiexample.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapiexample.R;
import com.example.postapiexample.model.DetailResponse;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {
    List<DetailResponse> nameLists;
    NameSelectionListener listener;

    public DetailAdapter(List<DetailResponse> body, NameSelectionListener listener) {
        this.nameLists = body;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_model, parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        final DetailResponse name =nameLists.get(position);
        holder.bind(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSelectName(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameLists !=null? nameLists.size():0;
    }

}
