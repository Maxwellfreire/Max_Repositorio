package com.example.teste.max_store;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);




        CardView btnImc = (CardView) findViewById(R.id.btnImc);
        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(SegundoActivity.this, ImcActivity.class);
                startActivity(MainIntent);


            }
        });
        CardView btnWeb = (CardView) findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(SegundoActivity.this, WebActivity.class);
                startActivity(MainIntent);




            }
        });
        CardView btnPorc = (CardView) findViewById(R.id.btnPorc);
        btnPorc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(SegundoActivity.this, PorcenActivity.class);
                startActivity(MainIntent);




            }
        });
        CardView btnSms = (CardView) findViewById(R.id.btnSms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(SegundoActivity.this, SmsActivity.class);
                startActivity(MainIntent);




            }
        });
        CardView btnBanco = (CardView) findViewById(R.id.btnJogo);
        btnBanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(SegundoActivity.this, VelhaActivity.class);
                startActivity(MainIntent);




            }
        });
    }


}
