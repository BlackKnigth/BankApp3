package com.example.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InitOldAdapter extends RecyclerView.Adapter<InitOldAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<ClassOldInit> Initiative;

    InitOldAdapter(Context context, List<ClassOldInit> Initiatives) {
        Initiative = Initiatives;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public InitOldAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.element_old_init, parent, false);

        return new InitOldAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InitOldAdapter.ViewHolder holder, int position) {
        ClassOldInit Init = Initiative.get(position);
        holder.oldName.setText(Init.getName());
        holder.oldImg.setImageResource(R.drawable.ic_menu_camera); /////////////////////////////////
    }

    @Override
    public int getItemCount() {
        return Initiative.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView oldName;
        final ImageView oldImg;

        ViewHolder(View view) {
            super(view);
            oldName = view.findViewById(R.id.oldName);
            oldImg = view.findViewById(R.id.oldImage);
        }
    }
}