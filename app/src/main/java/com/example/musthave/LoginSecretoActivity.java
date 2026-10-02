package com.example.musthave;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSecretoActivity extends AppCompatActivity {

    private EditText secretoEmailEditText;
    private EditText secretoPasswordEditText;
    private Button secretoLoginButton;
    private Button secretoSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_secreto); // Aponta para o XML renomeado

        secretoEmailEditText = findViewById(R.id.secretoEmailEditText);
        secretoPasswordEditText = findViewById(R.id.secretoPasswordEditText);
        secretoLoginButton = findViewById(R.id.secretoLoginButton);
        secretoSignUpButton = findViewById(R.id.secretoSignUpButton);

        secretoLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginSecretoActivity.this, "Login Secreto efetuado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}