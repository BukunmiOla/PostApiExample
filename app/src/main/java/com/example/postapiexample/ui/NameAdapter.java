package com.example.postapiexample.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postapiexample.R;
import com.example.postapiexample.model.NameResponse;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {
    List<NameResponse> nameLists;
    public NameAdapter(List<NameResponse> nameLists) {
        this.nameLists = nameLists;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_model, parent,false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        final NameResponse name = nameLists.get(position);
        holder.bind(name);
    }

    @Override
    public int getItemCount() {
        return nameLists!=null? nameLists.size():0;
    }
}
