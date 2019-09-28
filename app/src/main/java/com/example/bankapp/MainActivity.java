package com.example.bankapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<ClassOldInit> OldList = new ArrayList<>();
    List<ClassNewInit> NewList = new ArrayList<>();
    float startX = 0.f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Получить список старых инициатив
        final RecyclerView oldRecyclerView = findViewById(R.id.recyclerOld);
        OldList.add(new ClassOldInit(1, "Инициатива 1", "Описание инициативы 1"));
        OldList.add(new ClassOldInit(2, "Инициатива 2", "Описание инициативы 2"));
        OldList.add(new ClassOldInit(3, "Инициатива 3", "Описание инициативы 3"));
        final InitOldAdapter Adapter = new InitOldAdapter(this, OldList);

        oldRecyclerView.setAdapter(Adapter); //Заполнение
        oldRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        oldRecyclerView.addOnItemTouchListener(new RecyclerOldClickListener(this) { //Проверка свайпа

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

//                ClassNewInit Content = NewList.get(position);
//
//                Intent intent = new Intent(DialogActivity.this, ChatActivity.class);
//                intent.putExtra(EXTRA_MESSAGE, Content.getId());
//                intent.putExtra(EXTRA_MESSAGE2, Content.getUsername());
//                intent.putExtra(EXTRA_MESSAGE3, My_ID);
//                startActivity(intent);
            }
        });

        NewList.add(new ClassNewInit(1, "Инициатива 1", "Описание инициативы 1"));
        NewList.add(new ClassNewInit(2, "Инициатива 2", "Описание инициативы 2"));
        NewList.add(new ClassNewInit(3, "Инициатива 3", "Описание инициативы 3"));
        final InitNewAdapter Adapter2 = new InitNewAdapter(this, NewList);
        Adapter2.notifyDataSetChanged();

        final RecyclerView newRecyclerView = findViewById(R.id.recyclerNew);
        newRecyclerView.setAdapter(Adapter2); //Заполнение
        newRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        newRecyclerView.addOnItemTouchListener(new RecyclerNewClickListener(this) {

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN: //первое касание
                        startX = e.getX();
                        break;
                    case MotionEvent.ACTION_UP: //отпускание
                        float stopX = e.getX();
                        if (stopX - startX > 30.f || startX - stopX > 30.f) {
                            View clickedChild = rv.findChildViewUnder(e.getX(), e.getY());
                            if (clickedChild != null && !clickedChild.dispatchTouchEvent(e)) {
                                int clickedPosition = rv.getChildAdapterPosition(clickedChild);
                                if (clickedPosition != RecyclerView.NO_POSITION) {
                                    onItemSwipe(rv, clickedChild, clickedPosition,true);
                                    return true;
                                }
                            }
                        } else
                        if (startX == stopX) {
                            View clickedChild = rv.findChildViewUnder(e.getX(), e.getY());
                            if (clickedChild != null && !clickedChild.dispatchTouchEvent(e)) {
                                int clickedPosition = rv.getChildAdapterPosition(clickedChild);
                                if (clickedPosition != RecyclerView.NO_POSITION) {
                                    onItemSwipe(rv, clickedChild, clickedPosition,false);
                                    return true;
                                }
                            }
                        }
                        break;
                }
                return false;
            }

            @Override
            public void onItemSwipe(RecyclerView recyclerView, View itemView, int position, boolean isDelete) {
                if (isDelete) {
                    Adapter2.notifyItemRemoved(position);
                    NewList.remove(position);
                    //Удалить из бд
                } else
                {
//                    ClassNewInit Content = NewList.get(position);
//
//                    Intent intent = new Intent(DialogActivity.this, ChatActivity.class);
//                    intent.putExtra(EXTRA_MESSAGE, Content.getId());
//                    intent.putExtra(EXTRA_MESSAGE2, Content.getUsername());
//                    intent.putExtra(EXTRA_MESSAGE3, My_ID);
//                    startActivity(intent);
                }
            }
        });
        //Получить список новых инициатив
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_exit) {

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_confident) {

        } else if (id == R.id.nav_policy) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
