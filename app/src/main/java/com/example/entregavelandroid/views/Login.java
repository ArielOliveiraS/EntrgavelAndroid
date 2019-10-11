package com.example.entregavelandroid.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entregavelandroid.R;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";

    private TextInputLayout inputEmail;
    private TextInputLayout inputPassword;
    private Button buttonLogin;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getEditText().getText().toString();
                String password = inputPassword.getEditText().getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    Intent intent = new Intent(Login.this, Home.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(EMAIL_KEY, email);
                    bundle.putString(PASSWORD_KEY, password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Preencha o campo vazio!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Login.this, Cadastro.class));
            }
        });


    }

    public void initViews() {
        inputEmail = findViewById(R.id.email_login);
        inputPassword = findViewById(R.id.password_login);
        buttonLogin = findViewById(R.id.button_login);
        buttonCadastrar = findViewById(R.id.button_register);
    }

    }


