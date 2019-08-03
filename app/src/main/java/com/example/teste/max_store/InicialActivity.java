package com.example.teste.max_store;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class InicialActivity extends AppCompatActivity {
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        if(mySong == null) {
            mySong = MediaPlayer.create(InicialActivity.this, R.raw.dynoro);
            mySong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        mySong.start();

        ImageView btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mySong == null) {
                    mySong = MediaPlayer.create(InicialActivity.this, R.raw.dynoro);
                    mySong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopPlayer();
                        }
                    });
                }
                mySong.start();


            }
        });


        ImageView btnStop = (ImageView) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayer();


            }
        });
        CardView btnApp = (CardView) findViewById(R.id.btnApp);
        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PackageManager packageManager = getPackageManager();
                //String packageName = "com.whatsapp";
                //Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                //if(null != intent){
                    //startActivity(intent);
                //}
                Intent MainIntent = new Intent(InicialActivity.this, SegundoActivity.class);
                startActivity(MainIntent);




            }
        });



    }
    private void stopPlayer(){
        if(mySong != null){
            mySong.release();
            mySong = null;
            //Toast.makeText(this,"Música foi parada", Toast.LENGTH_SHORT).show();
        }

    }
    //@Override
    //protected void onStop(){
        //super.onStop();
        //stopPlayer();

    //}

}
