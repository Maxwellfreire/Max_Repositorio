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

import java.text.NumberFormat;

public class PorcenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcen);



        final float[] porc = new float[1];
        CardView btnCaluclar = (CardView) findViewById(R.id.btnCalcular);
        btnCaluclar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                final TextView editValor = (TextView) findViewById(R.id.editValor);
                final TextView editPorcentagem = (TextView) findViewById(R.id.editPorcentagem);
                final TextView tvResultado = (TextView) findViewById(R.id.tvResultado);

                String valor2 = editValor.getText().toString();
                String porcentagem2 = editPorcentagem.getText().toString();

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
                        editValor.setText("");
                        editPorcentagem.setText("");
                        tvResultado.setText("");
                    }
                });

                if(valor2.isEmpty()){

                    editValor.setError("O campo 'R$' está vazio !");

                    //Toast.makeText(PorcenActivity.this,"O campo 'R$' está vazio !", Toast.LENGTH_LONG).show();

                }else if(porcentagem2.isEmpty()){

                    editPorcentagem.setError("O campo '%' está vazio !");

                    //Toast.makeText(PorcenActivity.this,"O campo '%' está vazio !", Toast.LENGTH_LONG).show();

                }else {

                    NumberFormat nf = NumberFormat.getCurrencyInstance();


                    float valor = Float.parseFloat(editValor.getText().toString());
                    float porcentagem = Float.parseFloat(editPorcentagem.getText().toString());
                    porc[0] = (valor*porcentagem)/100;

                        tvResultado.setText(nf.format(porc[0]) + "");



                }

                closeKeyboard();

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
