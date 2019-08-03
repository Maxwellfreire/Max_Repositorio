package com.example.teste.max_store;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    ImageView btnCopiar;

    ClipboardManager clipboardManager;
    ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);


        btnCopiar = (ImageView) findViewById(R.id.btnCopiar);
        final EditText edit_Msg = (EditText) findViewById(R.id.edit_Msg);
        final EditText edit_encriptada = (EditText) findViewById(R.id.edit_encriptada);
        final EditText edit_New = (EditText) findViewById(R.id.edit_New);
        CardView btnEncriptar = (CardView) findViewById(R.id.btnEncriptar);
        CardView btnDescriptar = (CardView) findViewById(R.id.btnDescriptar);

        ImageView btnLimpar = (ImageView) findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_Msg.setText("");
                edit_encriptada.setText("");
                edit_New.setText("");
            }
        });


        btnEncriptar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                edit_encriptada.setText(Base64.encodeToString(edit_Msg.getText().toString().getBytes(), Base64.DEFAULT));

                closeKeyboard();
            }
        });

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        btnCopiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_encriptada.getText().toString();
                clipData = ClipData.newPlainText("text", text);
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(getApplicationContext(), "Código copiado com sucesso", Toast.LENGTH_SHORT).show();

            }


        });


        btnDescriptar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                edit_New.setText(new String(Base64.decode(edit_encriptada.getText().toString(), Base64.DEFAULT)));


            }
        });


    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
