package com.example.teste.max_store;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.widget.Toast;

public class AuthenticationHandler extends FingerprintManager.AuthenticationCallback {


    private LoginActivity loginActivity;


    public AuthenticationHandler(LoginActivity loginActivity) {
            this.loginActivity = loginActivity;


    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        Toast.makeText(loginActivity, " Erro: " + errString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
        Toast.makeText(loginActivity, "Auth Help: " + helpString, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        Toast.makeText(loginActivity, "Bem Vindo Maxwell :)" , Toast.LENGTH_SHORT).show();
        Intent i = new Intent(loginActivity.getApplicationContext(), HomeActivity.class);
        loginActivity.startActivity(i);



    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Toast.makeText(loginActivity, "Você não e o Maxwell :( " , Toast.LENGTH_SHORT).show();
    }
}
