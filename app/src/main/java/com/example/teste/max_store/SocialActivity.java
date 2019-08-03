package com.example.teste.max_store;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class SocialActivity extends AppCompatActivity {
    FloatingActionMenu actionMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        actionMenu=(FloatingActionMenu)findViewById(R.id.fabPrincipal);
        actionMenu.setClosedOnTouchOutside(true);




        FloatingActionButton btnWhatsapp = (FloatingActionButton) findViewById(R.id.btnWhatsapp);
        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getPackageManager();
                String packageName = "com.whatsapp";
                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if(null != intent){
                startActivity(intent);
                }


            }
        });
        FloatingActionButton btnFacebook = (FloatingActionButton) findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getPackageManager();
                String packageName = "com.facebook.katana";
                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if(null != intent){
                    startActivity(intent);
                }


            }
        });
        FloatingActionButton btnInst = (FloatingActionButton) findViewById(R.id.btnInst);
        btnInst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getPackageManager();
                String packageName = "com.instagram.android";
                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if(null != intent){
                    startActivity(intent);
                }


            }
        });
        FloatingActionButton btnYou = (FloatingActionButton) findViewById(R.id.btnYou);
        btnYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager packageManager = getPackageManager();
                String packageName = "com.google.android.youtube";
                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if(null != intent){
                    startActivity(intent);
                }


            }
        });





    }




}
