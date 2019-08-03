package com.example.teste.max_store;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TerceiroActivity extends AppCompatActivity {
    MediaPlayer mySong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceiro);


        final float[] imc = new float[1];
        Button btnCaluclar = (Button) findViewById(R.id.btnCalcular);
        btnCaluclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editPeso = (TextView) findViewById(R.id.editPeso);
                TextView editAltura = (TextView) findViewById(R.id.editAltura);
                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                TextView tvDescricao = (TextView) findViewById(R.id.tvDescricao);
                String peso2 = editPeso.getText().toString();
                String altura1 = editAltura.getText().toString();
                if(peso2.isEmpty()){

                    Toast.makeText(TerceiroActivity.this,"O campo Peso está vazio !", Toast.LENGTH_LONG).show();

                }else if(altura1.isEmpty()){

                    Toast.makeText(TerceiroActivity.this,"O campo Altura está vazio !", Toast.LENGTH_LONG).show();

                }else {

                    int peso = Integer.parseInt(editPeso.getText().toString());
                    float altura = Float.parseFloat(editAltura.getText().toString());
                    imc[0] = peso / (altura * altura);


                    if (imc[0] >= 0 && imc[0] < 18.5) {
                        tvResultado.setText(imc[0] + "");
                        tvDescricao.setText("'Precisa comer mais', Baixo Peso");
                    } else {
                        if (imc[0] >= 18.5 && imc[0] < 25) {
                            tvResultado.setText(imc[0] + "");
                            tvDescricao.setText("Peso adequado");

                        } else {
                            if (imc[0] >= 25 && imc[0] < 30) {
                                tvResultado.setText(imc[0] + "");
                                tvDescricao.setText("Sobrepeso");
                            } else {
                                tvResultado.setText(imc[0] + "");
                                tvDescricao.setText("'Obesidade");

                            }


                        }

                    }

                }

            }
        });


    }


}
