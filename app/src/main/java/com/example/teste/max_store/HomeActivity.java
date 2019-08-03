package com.example.teste.max_store;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class HomeActivity extends AppCompatActivity {
    MediaPlayer mySong;
    FloatingActionMenu actionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        actionMenu=(FloatingActionMenu)findViewById(R.id.fabPrincipal);
        actionMenu.setClosedOnTouchOutside(true);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        if(mySong == null) {
            mySong = MediaPlayer.create(HomeActivity.this, R.raw.dynoro);
            mySong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        mySong.start();

        FloatingActionButton btnPlay = (FloatingActionButton) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mySong == null) {
                    mySong = MediaPlayer.create(HomeActivity.this, R.raw.dynoro);
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



        FloatingActionButton btnStop = (FloatingActionButton) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayer();


            }
        });

        FloatingActionButton btnPause = (FloatingActionButton) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mySong != null){
                    mySong.pause();
                }

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
                Intent MainIntent = new Intent(HomeActivity.this, SegundoActivity.class);
                startActivity(MainIntent);




            }
        });
        CardView btnBanco = (CardView) findViewById(R.id.btnBanco);
        btnBanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(HomeActivity.this, BancoActivity.class);
                startActivity(MainIntent);




            }
        });
        CardView btnSocial = (CardView) findViewById(R.id.btnSocial);
        btnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainIntent = new Intent(HomeActivity.this, SocialActivity.class);
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
