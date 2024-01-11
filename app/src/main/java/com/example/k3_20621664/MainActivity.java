package com.example.k3_20621664;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insLife = findViewById(R.id.btnInsuranceLife);
        Button insCitizen = findViewById(R.id.btnInsuranceCitizen);
        Button insHome = findViewById(R.id.btnInsuranceHome);

        insLife.setEnabled(false);
        insCitizen.setEnabled(false);
        insHome.setEnabled(false);

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

        Spinner spinner = findViewById(R.id.chooseInsuranse);

        String[] insuranceType = {"Life Insurance", "Citizen Insurance", "Home Insurance"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, insuranceType);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //String selectedValue = (String) parentView.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

        Button btnNext = findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedValue = (String) spinner.getSelectedItem();
                if(selectedValue.equals("Life Insurance")){
                    Intent intent = new Intent(MainActivity.this, InsuranceDisplay.class);
                    intent.putExtra("life", "life");
                    startActivity(intent);
                } else if(selectedValue.equals("Citizen Insurance")){
                    Intent intent = new Intent(MainActivity.this, InsuranceDisplay.class);
                    intent.putExtra("citizen", "citizen");
                    startActivity(intent);
                } else if(selectedValue.equals("Home Insurance")){
                    Intent intent = new Intent(MainActivity.this, InsuranceDisplay.class);
                    intent.putExtra("home", "home");
                    startActivity(intent);
                }
            }
        });
    }
}