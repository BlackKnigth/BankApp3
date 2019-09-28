package com.example.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InitNewAdapter extends RecyclerView.Adapter<InitNewAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<ClassNewInit> Initiative;

    InitNewAdapter(Context context, List<ClassNewInit> Initiatives) {
        Initiative = Initiatives;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public InitNewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.element_new_init, parent, false);
        return new InitNewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InitNewAdapter.ViewHolder holder, int position) {
        ClassNewInit Init = Initiative.get(position);
        holder.newName.setText(Init.getName());
        holder.newDescr.setText(Init.getDescript());
    }

    @Override
    public int getItemCount() {
        return Initiative.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView newName, newDescr;

        ViewHolder(View view) {
            super(view);
            newName = view.findViewById(R.id.newName);
            newDescr = view.findViewById(R.id.newDescr);

        }
    }
}
