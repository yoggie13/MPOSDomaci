package com.example.mpdomaci1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void check(View view){
        EditText text = findViewById(R.id.Singer);
        String singer = text.getText().toString();

        if(singer.isEmpty() || singer == " ") {
            Toast.makeText(this,"Morate uneti ime izvođača!",Toast.LENGTH_LONG).show();
            return;
        }

        submitAnswer(singer);
    }
    public void submitAnswer(String singer) {

        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra("singer", singer);
        startActivity(intent);
    }

}