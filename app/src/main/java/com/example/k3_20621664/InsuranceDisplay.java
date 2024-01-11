package com.example.k3_20621664;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class InsuranceDisplay extends AppCompatActivity{
    InsuranceAdapter adapter;
    List<Insurance> insuranceList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_display);

        TextView insType = findViewById(R.id.insuranceType);

        Intent intent = getIntent();
        String insHomeExtra = intent.getStringExtra("home");
        String insCitizenExtra = intent.getStringExtra("citizen");
        String insLifeExtra = intent.getStringExtra("life");

        if("home".equals(insHomeExtra)){
            insType.setText("Home Insurance");
        } else if("citizen".equals(insCitizenExtra)){
            insType.setText("Citizen Insurance");
        } else if("life".equals(insLifeExtra)){
            insType.setText("Life Insurance");
        }

        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if("home".equals(insHomeExtra)){
            insuranceList = InsuranceGenerator.generateList(5, "home");
        } else if("citizen".equals(insCitizenExtra)){
            insuranceList = InsuranceGenerator.generateList(5, "citizen");
        } else if("life".equals(insLifeExtra)){
            insuranceList = InsuranceGenerator.generateList(5, "life");
        }

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new InsuranceAdapter(insuranceList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HandlerThread handlerThread = new HandlerThread("InsuranceThread");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                Bundle bundle = msg.getData();
                int change = bundle.getInt("index", -1);

                if(change != -1){
                    Insurance changedInsurance = insuranceList.get(change);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        };

        handler.post(new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();

                int randomIndex = (int) (Math.random() * insuranceList.size());
                Insurance randomIns = insuranceList.get(randomIndex);

                if(randomIns.getInsuranceStatus().equals("Active")) {
                    randomIns.setInsuranceStatus("Not Active");
                } else if(randomIns.getInsuranceStatus().equals("Not Active")){
                    randomIns.setInsuranceStatus("Active");
                } else {
                    randomIns.setInsuranceStatus("Unavailable");
                }

                bundle.putInt("index", randomIndex);

                message.setData(bundle);
                handler.sendMessage(message);
                handler.postDelayed(this, 4000);
            }
        });
    }


}