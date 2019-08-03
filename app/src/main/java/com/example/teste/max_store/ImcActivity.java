package com.example.teste.max_store;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class ImcActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);



        TextView editAltura = (TextView) findViewById(R.id.editAltura);
        //Criar mascara pra colocar numero telefonico
        SimpleMaskFormatter smf = new SimpleMaskFormatter("N.NN");
        MaskTextWatcher mtw = new MaskTextWatcher(editAltura, smf);
        editAltura.addTextChangedListener(mtw);
        //Fim da mascara


        final float[] imc = new float[1];
        CardView btnCaluclar = (CardView) findViewById(R.id.btnCalcular);
        btnCaluclar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                final ImageView imagem = (ImageView) findViewById(R.id.imagem);
                final TextView editPeso = (TextView) findViewById(R.id.editPeso);
                final TextView editAltura = (TextView) findViewById(R.id.editAltura);
                final TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                final TextView tvDescricao = (TextView) findViewById(R.id.tvDescricao);
                String peso2 = editPeso.getText().toString();
                String altura1 = editAltura.getText().toString();

                ImageView btnFechar = (ImageView) findViewById(R.id.btnFechar);

                btnFechar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });

                ImageView btnLimpar = (ImageView) findViewById(R.id.btnLimpar);

                btnLimpar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editPeso.setText("");
                        editAltura.setText("");
                        tvResultado.setText("");
                        tvDescricao.setText("");
                        imagem.setImageDrawable(getDrawable(R.drawable.imc));
                    }
                });

                if(peso2.isEmpty()){

                    editPeso.setError("O campo Peso está vazio !");

                    //Toast.makeText(ImcActivity.this,"O campo Peso está vazio !", Toast.LENGTH_LONG).show();

                }else if(altura1.isEmpty()){

                    editAltura.setError("O campo Altura está vazio !");



                }else {

                    float peso = Float.parseFloat(editPeso.getText().toString());
                    float altura = Float.parseFloat(editAltura.getText().toString());
                    imc[0] = peso / (altura * altura);


                    if (imc[0] >= 0 && imc[0] < 18.5) {
                        tvResultado.setText(imc[0] + "");
                        tvDescricao.setText("Baixo Peso");
                        imagem.setImageDrawable(getDrawable(R.drawable.baixopeso));
                    } else {
                        if (imc[0] >= 18.5 && imc[0] < 25) {
                            tvResultado.setText(imc[0] + "");
                            tvDescricao.setText("Peso adequado");
                            imagem.setImageDrawable(getDrawable(R.drawable.pesoadequado));

                        } else {
                            if (imc[0] >= 25 && imc[0] < 30) {
                                tvResultado.setText(imc[0] + "");
                                tvDescricao.setText("Sobrepeso");
                                imagem.setImageDrawable(getDrawable(R.drawable.sobrepeso));
                            } else {
                                tvResultado.setText(imc[0] + "");
                                tvDescricao.setText("Obesidade");
                                imagem.setImageDrawable(getDrawable(R.drawable.obesidade));

                            }


                        }

                        closeKeyboard();

                    }

                    closeKeyboard();



                }

            }
        });


    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }




}
