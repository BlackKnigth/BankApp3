package com.example.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InitAdapter extends RecyclerView.Adapter<InitAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<ClassOldInit> Initiative;
    private boolean oldList;

    InitAdapter(Context context, List<ClassOldInit> Initiatives, boolean OldList) {
        Initiative = Initiatives;
        inflater = LayoutInflater.from(context);
        oldList = OldList;
    }
    @Override
    public InitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if (oldList)
            view = inflater.inflate(R.layout.element_old_init, parent, false);
        else
            view = inflater.inflate(R.layout.element_new_init, parent, false);
        return new InitAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InitAdapter.ViewHolder holder, int position) {
        ClassOldInit Init = Initiative.get(position);
        if (oldList) {
            holder.oldName.setText(Init.getName());
            holder.oldImg.;
        }
        else
        {
            holder.newName.setText(Init.getName());
            holder.newDescr.setText(Init.getDescript());
        }
    }

    @Override
    public int getItemCount() {
        return Initiative.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView oldName, newName, newDescr;
        final ImageView oldImg;
        ViewHolder(View view){
            super(view);
            if (oldList) {
                oldName = view.findViewById(R.id.oldName);
                oldImg = view.findViewById(R.id.oldImage);
                newName = null;
                newDescr = null;
            }
            else
            {
                oldName = null;
                oldImg = null;
                newName = view.findViewById(R.id.newName);
                newDescr = view.findViewById(R.id.newDescr);
            }
        }
    }
}
