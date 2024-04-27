package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash_Activity extends AppCompatActivity {
    CardView scardView;
    TextView stext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        scardView=findViewById(R.id.splashlogo);
        stext=findViewById(R.id.splashtext);

        Animation uptodownAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);
        Animation downtoupAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        scardView.startAnimation(uptodownAnim);
        stext.startAnimation(downtoupAnim);

        new Handler().postDelayed(() -> {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}