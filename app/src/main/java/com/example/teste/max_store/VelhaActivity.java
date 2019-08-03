package com.example.teste.max_store;

import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VelhaActivity extends AppCompatActivity {
    private Button[] arrayButton = new Button[10];
    private String vez = "A";
    private int jogadas = 0;
    private String [] matriz = new String [10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velha);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        inicializaButtons();
        onClickButtons();


    }

    private void inicializaButtons(){

        arrayButton[1] = (Button) findViewById(R.id.btn1);
        arrayButton[2] = (Button) findViewById(R.id.btn2);
        arrayButton[3] = (Button) findViewById(R.id.btn3);
        arrayButton[4] = (Button) findViewById(R.id.btn4);
        arrayButton[5] = (Button) findViewById(R.id.btn5);
        arrayButton[6] = (Button) findViewById(R.id.btn6);
        arrayButton[7] = (Button) findViewById(R.id.btn7);
        arrayButton[8] = (Button) findViewById(R.id.btn8);
        arrayButton[9] = (Button) findViewById(R.id.btn9);

    }

    private void onClickButtons(){
        for (int  x = 1; x<10;x++){
            final int finalX = x;
            arrayButton[finalX].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {
                    jogada(finalX);
                }
            });
            matriz[x]="";



        }



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void jogada (int x){
        final ImageView imagem = (ImageView) findViewById(R.id.imagem);
        final TextView tvQuem = (TextView) findViewById(R.id.tvQuem);

        if(matriz[x] == ""){
            matriz[x] = vez;
            jogadas++;
            if (vez == "A"){
                vez = "J";
                imagem.setImageDrawable(getDrawable(R.drawable.joaninha));
                tvQuem.setText("Joaninha");

            }else{
                vez = "A";
                imagem.setImageDrawable(getDrawable(R.drawable.abelinha));
                tvQuem.setText("Abelinha");

            }

        }
        exibirButtons();
        verifica();

    }
    private void exibirButtons(){
        for(int x = 1; x<10;x++){
            arrayButton[x].setText(matriz[x]);



        }



    }

    private void verifica(){
        if(matriz[1].equals(matriz[2]) && matriz[1].equals(matriz[3]) && matriz[1].toString() != ""){
            ganhador(matriz[1]);
            return;
        }
        if(matriz[4].equals(matriz[5]) && matriz[4].equals(matriz[6]) && matriz[4].toString() != ""){
            ganhador(matriz[4]);
            return;
        }
        if(matriz[7].equals(matriz[8]) && matriz[7].equals(matriz[9]) && matriz[7].toString() != ""){
            ganhador(matriz[7]);
            return;
        }
        if(matriz[1].equals(matriz[4]) && matriz[1].equals(matriz[7]) && matriz[1].toString() != ""){
            ganhador(matriz[1]);
            return;
        }
        if(matriz[2].equals(matriz[5]) && matriz[2].equals(matriz[8]) && matriz[2].toString() != ""){
            ganhador(matriz[2]);
            return;
        }
        if(matriz[3].equals(matriz[6]) && matriz[3].equals(matriz[9]) && matriz[3].toString() != ""){
            ganhador(matriz[3]);
            return;
        }
        if(matriz[1].equals(matriz[5]) && matriz[1].equals(matriz[9]) && matriz[1].toString() != ""){
            ganhador(matriz[1]);
            return;
        }
        if(matriz[3].equals(matriz[5]) && matriz[3].equals(matriz[7]) && matriz[3].toString() != ""){
            ganhador(matriz[3]);
            return;
        }

        if (jogadas == 9){
            ganhador("");
            return;

        }



    }

    private void ganhador(String ganhador){

        AlertDialog.Builder builder = new AlertDialog.Builder (VelhaActivity.this);
        builder.setTitle("Resultado");
        if (ganhador.equals("")){
            builder.setMessage("Empate");

        }else{
            if (ganhador.equals("A")){
                builder.setMessage("A \"Abelinha\" é a vencedora");

            }else{

                builder.setMessage("A \"Joaninha\" é a vencedora");
            }

        }
        builder.setPositiveButton("Novo Jogo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                jogadas = 0;
                for (int x = 1; x<10; x++){
                    matriz[x]="";


                }
                exibirButtons();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();



    }



}
