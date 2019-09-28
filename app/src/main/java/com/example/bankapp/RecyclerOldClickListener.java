package com.example.bankapp;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerOldClickListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private GestureDetector.OnGestureListener gestureListener =
            new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            };

    public RecyclerOldClickListener(Context context) {
        gestureDetector = new GestureDetector(context, gestureListener);
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    public abstract void onItemSwipe(RecyclerView recyclerView, View itemView, int position, boolean isDelete);
}