package com.example.musthave;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int contadorCliques = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logoImageView = findViewById(R.id.logoImageView);
        Button signUpButton = findViewById(R.id.signUpButton);
        Button loginButton = findViewById(R.id.loginButton);

        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contadorCliques++;

                if(contadorCliques == 3) {
                    Toast.makeText(MainActivity.this, "Faltam 2 cliques para o menu secreto", Toast.LENGTH_SHORT).show();
                }

                if(contadorCliques == 5) {
                    contadorCliques = 0;

                    Intent intent = new Intent(MainActivity.this, LoginSecretoActivity.class);
                    startActivity(intent);
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OutfitActivity.class);
                startActivity(intent);
            }
        });
    }
}
