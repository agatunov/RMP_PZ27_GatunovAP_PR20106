package com.example.pz27_gatunovap_pr20106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingsScreen extends AppCompatActivity {
    TextView loginTv, emailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        loginTv = (TextView) findViewById(R.id.userNameField);
        emailTv = (TextView) findViewById(R.id.emailField1);
        loginTv.setText(User.username);
        emailTv.setText(User.email);

    }
    public void menuBackBtn(View view) {
        Intent i = new Intent(SettingsScreen.this, MenusScreen.class);
        startActivity(i);
    }
}