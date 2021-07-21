package com.example.mpdomaci1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends BaseActivity {

    private static String singer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        singer = getIntent().getStringExtra("singer");

        answer(singer);

        Button voz = findViewById(R.id.btnVoz);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bajaga);
        voz.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });
    }
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Ako treba da je kraj")
                .setMessage("Da li verujete u to da je Bajaga svima omiljeni izvođač?")
                .setNegativeButton("Ne verujem", null)
                .setPositiveButton("Verujem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .show();

    }


    private void answer(String singer){
        TextView text = findViewById(R.id.txtAnswer);
        String show = "";

        if(singer.toLowerCase().contains("bajaga")){
            show = "Bajaga je uvek tačan odgovor!";
        }else{
            show = "Netačan odgovor. Trebalo je da odgovorite Bajaga!";
        }

        text.setText(show);
    }


}