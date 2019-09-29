package com.example.bankapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView userID;
    TextView msg;

    public ViewHolder(View itemView) {
        super(itemView);
        msg = itemView.findViewById(R.id.message_item);
        userID = itemView.findViewById(R.id.userid_item);
    }
}
