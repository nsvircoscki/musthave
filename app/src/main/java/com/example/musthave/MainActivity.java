package com.example.musthave;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup; // Importação adicionada para o BlurView funcionar
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class MainActivity extends AppCompatActivity {

    private int contadorCliques = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logoImageView = findViewById(R.id.logoImageView);

        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // A correção da lógica: agora os cliques são contados a cada toque
                contadorCliques++;

                if(contadorCliques == 3) {
                    Toast.makeText(MainActivity.this, "Faltam 2 cliques para o menu secreto", Toast.LENGTH_SHORT).show();
                }

                if(contadorCliques == 5) {
                    contadorCliques = 0; // Zera para o futuro

                    Intent intent = new Intent(MainActivity.this, LoginSecretoActivity.class);
                    startActivity(intent);
                }
            }
        });

        // Configuração do efeito de vidro em tempo real
        View decorView = getWindow().getDecorView();
        ViewGroup rootView = decorView.findViewById(android.R.id.content);

        BlurView blurViewEmail = findViewById(R.id.blurViewEmail);

        float radius = 15f;

        blurViewEmail.setupWith(rootView, new RenderScriptBlur(this))
                .setBlurRadius(radius);
    }
}