package com.example.pz27_gatunovap_pr20106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick (View view) {
        Intent i = new Intent(MainActivity.this, SignScreen.class);
        startActivity(i);
    }


}