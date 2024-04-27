package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Objects;

public class Activity_Seiiting extends AppCompatActivity {
    Toolbar toolbar;
    ImageButton bckbtn;

    LinearLayout shareApp, feedback, userManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seiiting);
        bckbtn=findViewById(R.id.backbtn);
        toolbar=findViewById(R.id.toolbar);
        shareApp=findViewById(R.id.shareApp);
        feedback=findViewById(R.id.feedback);
        userManual=findViewById(R.id.usermanual);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        bckbtn.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        shareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        userManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}