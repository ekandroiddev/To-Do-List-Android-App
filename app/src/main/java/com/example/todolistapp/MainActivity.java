package com.example.todolistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView emptyMSG;

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    Intent intent;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.bgColor));

        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.topAppBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerview);
        floatingActionButton = findViewById(R.id.floatingActionBtn);
        emptyMSG=findViewById(R.id.emptyMSG);

        floatingActionButton.setOnClickListener(v -> {
            CustomAddTaskDialog dialog = new CustomAddTaskDialog(this);
            dialog.show();
        });

        // Set up RecyclerView with LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create and set RecyclerViewAdapter with an empty list initially
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(recyclerViewAdapter);

        // Observe database changes and update RecyclerViewAdapter
        AppDataBase appDataBase = AppDataBase.getInstance(this);
        DaoTaskTabel daoTaskTabel = appDataBase.daoTaskTabel();
        daoTaskTabel.getAllTask().observe(this, taskEntities -> {
            recyclerViewAdapter.setItemList(taskEntities);
            recyclerViewAdapter.notifyDataSetChanged();

            // Update visibility of empty message TextView and RecyclerView
            if (taskEntities.isEmpty()) {
                emptyMSG.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            } else {
                emptyMSG.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.nav_menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if (itemId==R.id.promem){

           AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

            builder.setTitle("Pro Mode")
                    .setMessage("This feature not implemented yet!");

            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        else {
            intent = new Intent(MainActivity.this, Activity_Seiiting.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}