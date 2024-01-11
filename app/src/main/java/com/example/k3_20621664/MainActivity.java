package com.example.k3_20621664;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insLife = findViewById(R.id.btnInsuranceLife);
        Button insCitizen = findViewById(R.id.btnInsuranceCitizen);
        Button insHome = findViewById(R.id.btnInsuranceHome);

        insLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsuranceDisplay.class);
                intent.putExtra("life", "life");
                startActivity(intent);
            }
        });

        insCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsuranceDisplay.class);
                intent.putExtra("citizen", "citizen");
                startActivity(intent);
            }
        });

        insHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsuranceDisplay.class);
                intent.putExtra("home", "home");
                startActivity(intent);
            }
        });
    }
}