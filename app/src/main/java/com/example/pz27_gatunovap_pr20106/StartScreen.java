package com.example.pz27_gatunovap_pr20106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }
    public void menuBtn (View view) {
        Intent i = new Intent(StartScreen.this, MenusScreen.class);
        startActivity(i);
    }
}