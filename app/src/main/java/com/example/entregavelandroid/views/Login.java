package com.example.entregavelandroid.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.entregavelandroid.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private TextInputLayout inputEmail;
    private TextInputLayout inputPassword;
    private Button buttonLogin;
    private Button buttonCadastrar;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    private String email, senha;
    public static final String EMAIL_KEY = "email";
    public static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDados();

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
    public void validarDados(){
        inputEmail.setErrorEnabled(false);
        inputPassword.setErrorEnabled(false);

        email = inputEmail.getEditText().getText().toString().trim();
        senha = inputPassword.getEditText().getText().toString().trim();

        if (!validateEmail(email) && !validatePassword(senha)) {
            inputEmail.setError("E-mail invalido");
            inputPassword.setError("Mínimo 6 caractéres!");
        } else if (!validatePassword(senha)) {
            inputPassword.setError("Mínimo 6 caractéres!");
            inputEmail.setErrorEnabled(false);
        } else if(!validateEmail(email)){
            inputEmail.setError("E-mail invalido");
            inputPassword.setErrorEnabled(false);
        }else{

            inputEmail.setErrorEnabled(false);
            inputPassword.setErrorEnabled(false);

            startActivity(new Intent(Login.this, Home.class));

        }

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }
}




