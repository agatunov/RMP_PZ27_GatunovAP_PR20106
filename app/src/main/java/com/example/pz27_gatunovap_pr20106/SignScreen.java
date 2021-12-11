package com.example.pz27_gatunovap_pr20106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignScreen extends AppCompatActivity {
    DBHelper dbHelper;
    EditText loginEt, passwordEt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_screen);
        loginEt = (EditText) findViewById(R.id.loginField);
        passwordEt = (EditText) findViewById(R.id.passwrodField);
        dbHelper = new DBHelper(this);
    }
    public void signInClick (View view)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String login = loginEt.getText().toString();
        String password = passwordEt.getText().toString();
        Cursor cursor = database.query(DBHelper.TABLE_USERS, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int loginIndex = cursor.getColumnIndex(DBHelper.KEY_LOGIN);
            int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
            String loginDb = cursor.getString(loginIndex);
            String passwordDb = cursor.getString(passwordIndex);
            if (login.equals(loginDb) || password.equals(passwordDb)) {
                dbHelper.close();
                Intent i = new Intent(SignScreen.this, MainActivity.class);
                startActivity(i);
            }
        }
        cursor.close();
        dbHelper.close();
    }
    public void signUpClick (View view){
        Intent i = new Intent(SignScreen.this, SignUpScreen.class);
        startActivity(i);
    }
}

