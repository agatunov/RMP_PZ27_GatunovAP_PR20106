package com.example.pz27_gatunovap_pr20106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenusScreen extends AppCompatActivity {
private TextView userField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_screen);
        userField = (TextView) findViewById(R.id.userField);
        userField.setText(User.username);
    }
    public void menuReturnBtn(View view) {
        Intent i = new Intent(MenusScreen.this, StartScreen.class);
        startActivity(i);
    }
    public void historyBtn(View view) {
        Intent i = new Intent(MenusScreen.this, HistoryScreen.class);
        startActivity(i);
    }
    public void settingsBtn(View view) {
        Intent i = new Intent(MenusScreen.this, SettingsScreen.class);
        startActivity(i);
    }
}