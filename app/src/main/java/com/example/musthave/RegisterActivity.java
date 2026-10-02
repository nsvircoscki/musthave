package com.example.musthave;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText birthDateEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             setContentView(R.layout.register_activity);

        nameEditText = findViewById(R.id.nameEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String birthDate = birthDateEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (name.isEmpty() || birthDate.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(RegisterActivity.this, "Cadastro confirmado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, OutfitActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}