package com.example.entregavelandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entregavelandroid.R;
import com.google.android.material.textfield.TextInputLayout;

public class Cadastro extends AppCompatActivity {

    private TextInputLayout inputEmail;
    private TextInputLayout inputNome;
    private TextInputLayout inputPassword;
    private TextInputLayout inputPasswordConfirm;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        initViews();

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nome = inputNome.getEditText().getText().toString();
               String email = inputEmail.getEditText().getText().toString();
               String password = inputPassword.getEditText().getText().toString();
               String passwordConfirm = inputPasswordConfirm.getEditText().getText().toString();

                if (!nome.isEmpty() && !email.isEmpty() && !password.isEmpty() && !passwordConfirm.isEmpty()) {
                    Intent intent = new Intent(Cadastro.this, Home.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Preencha o campo vazio!", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void initViews() {
        inputNome = findViewById(R.id.inputNome);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputPasswordConfirm = findViewById(R.id.inputPasswordConfirm);
        buttonCadastrar = findViewById(R.id.buttonRegistrar);
    }

}


