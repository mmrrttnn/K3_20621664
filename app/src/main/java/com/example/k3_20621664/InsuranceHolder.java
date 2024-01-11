package com.example.k3_20621664;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InsuranceHolder extends RecyclerView.ViewHolder {
    TextView name, price, status, compensation;


    public InsuranceHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.lineInsName);
        price = itemView.findViewById(R.id.lineInsPrice);
        status = itemView.findViewById(R.id.lineInsStatus);
        compensation = itemView.findViewById(R.id.lineInsCompensation);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setPrice(String price) {
        this.price.setText(price);
    }

    public void setStatus(String status) {
        this.status.setText(status);
    }

    public void setCompensation(String compensation) {
        this.compensation.setText(compensation);
    }
}
