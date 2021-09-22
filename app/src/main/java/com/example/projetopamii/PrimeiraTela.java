package com.example.projetopamii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PrimeiraTela extends AppCompatActivity {

    public static EditText mtxtlatitude, mtxtlongitude;


    Button pesquisa;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_tela);
        Button pesquisa = (Button) findViewById(R.id.pesquisa);
        mtxtlatitude = findViewById(R.id.mtxtlatitude);
        mtxtlongitude = findViewById(R.id.mtxtlongitude);


        pesquisa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMapsActivity();
            }

        });

    }

    private void openMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
