package com.example.bankapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<ClassOldInit> OldList = new ArrayList<>();

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
        final RecyclerView oldRecyclerView =  findViewById(R.id.recyclerOld);
        OldList.add(new ClassOldInit(1, "Инициатива 1", "Описание инициативы 1"));
        OldList.add(new ClassOldInit(1, "Инициатива 2", "Описание инициативы 2"));
        OldList.add(new ClassOldInit(1, "Инициатива 3", "Описание инициативы 3"));
        InitAdapter Adapter = new InitAdapter(this, OldList, true);
        oldRecyclerView.setAdapter(Adapter);
        oldRecyclerView.addOnItemTouchListener(new RecyclerClickListener(this) {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }

            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {

                ClassOldInit Init = OldList.get(position);

                Intent intent = new Intent(DialogActivity.this, ChatActivity.class);
                intent.putExtra(EXTRA_MESSAGE, Init.getId());
                intent.putExtra(EXTRA_MESSAGE2, Init.getUsername());
                intent.putExtra(EXTRA_MESSAGE3, );
                startActivity(intent);
            }
        });

        final RecyclerView newRecyclerView =  findViewById(R.id.recyclerNew);

        //Получить список новых инициатив
        List
        CatAdapter = new InitAdapter(this, UserList);
        oldRecyclerView.setAdapter(CatAdapter);
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
            // Handle the camera action
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
