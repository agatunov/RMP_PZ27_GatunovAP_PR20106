package com.example.pz27_gatunovap_pr20106;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Optional;
import javax.xml.validation.SchemaFactoryLoader;

public class SignUpScreen extends AppCompatActivity {
    DBHelper dbHelper;
    EditText loginEt, emailEt, passwordEt, passwordRepeatEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        loginEt = (EditText) findViewById(R.id.loginField);
        emailEt = (EditText) findViewById(R.id.emailField);
        passwordEt = (EditText) findViewById(R.id.passwrodField);
        passwordRepeatEt = (EditText) findViewById(R.id.passwrodFieldRepeat);
        dbHelper = new DBHelper(this);
    }


    public void signUp(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = database.query(DBHelper.TABLE_USERS, null, null, null, null, null, null);
        String login = loginEt.getText().toString();
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        String password2 = passwordRepeatEt.getText().toString();
        Toast toast;
        boolean check = true;
        if (password.equals(password2)) {
            while (cursor.moveToNext()) {
                int loginIndex = cursor.getColumnIndex(DBHelper.KEY_LOGIN);
                int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
                String loginDb = cursor.getString(loginIndex);
                String emailDb = cursor.getString(emailIndex);
                if (login.equals(loginDb)) {
                    toast = Toast.makeText(getApplicationContext(), "Логин уже зарегистрированы в системе", Toast.LENGTH_LONG);
                    toast.show();
                    check = false;
                    break;
                }
                if (email.equals(emailDb)) {
                    toast = Toast.makeText(getApplicationContext(), "Почта уже зарегистрирована в системе", Toast.LENGTH_LONG);
                    toast.show();
                    check = false;
                    break;
                }
            }
            if (check) {
                contentValues.put(DBHelper.KEY_LOGIN, login);
                contentValues.put(DBHelper.KEY_PASSWORD, password);
                contentValues.put(DBHelper.KEY_EMAIL, email);
                database.insert(DBHelper.TABLE_USERS, null, contentValues);
            }
        } else {
            toast = Toast.makeText(getApplicationContext(), "Пароли не совпадают", Toast.LENGTH_LONG);
            toast.show();
        }
        Logs();
        cursor.close();
        dbHelper.close();
    }

    public void Logs() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_USERS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int loginIndex = cursor.getColumnIndex(DBHelper.KEY_LOGIN);
            int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
            int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
            do {
                Log.d("mLog", "ID= " + cursor.getInt(idIndex) +
                        ", login = " + cursor.getString(loginIndex) +
                        ", password = " + cursor.getString(passwordIndex) +
                        ", email = " + cursor.getString(emailIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");
        cursor.close();
        dbHelper.close();
    }





}
