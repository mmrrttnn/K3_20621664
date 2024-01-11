package com.example.k3_20621664;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceHolder> {
    private List<Insurance> insuranceList;
    private Context context;

    public InsuranceAdapter(List<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }

    @NonNull
    @Override
    public InsuranceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View insuranceView = inflater.inflate(R.layout.line_item_layout, parent, false);
        InsuranceHolder insuranceHolder = new InsuranceHolder(insuranceView);
        return insuranceHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InsuranceHolder holder, int position) {
        Insurance item = insuranceList.get(position);

        holder.setName(item.getInsuranceName());
        holder.setPrice(String.valueOf(item.getInsurancePrice()));
        holder.setStatus(item.getInsuranceStatus());
        holder.setCompensation(String.valueOf(item.getInsuranceCompensation()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, InsuranceFragment.newInstance(item), "fragment");
                ft.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return insuranceList.size();
    }
}
