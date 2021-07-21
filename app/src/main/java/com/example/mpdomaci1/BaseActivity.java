package com.example.mpdomaci1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    static boolean checkDark = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


    }

    @Override
    protected void onResume() {

        Switch s = findViewById(R.id.darkMode);
        s.setChecked(checkDark);
        changeMode(s);

        super.onResume();

    }



    public void changeMode(View view) {
        Switch sw = findViewById(R.id.darkMode);

        if(checkDarkMode()) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            sw.setText("... nekad žut");
        }else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            sw.setText("Život je nekad siv...");
        }
    }
    public boolean checkDarkMode(){
        Switch s = findViewById(R.id.darkMode);
        checkDark = s.isChecked();
        return s.isChecked();
    }
}
