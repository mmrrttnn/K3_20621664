package com.example.k3_20621664;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsuranceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsuranceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Insurance insurance;
    private EditText name, price, status, compensation;
    private Button btnSave, btnCancel;
    private OnInsuranceUpdatedListener listener;

    // TODO: Rename and change types of parameters

    public InsuranceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     /* @param param1 Parameter 1.
     /* @param param2 Parameter 2.
     * @return A new instance of fragment InsuranceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsuranceFragment newInstance(Insurance insurance) {
        InsuranceFragment fragment = new InsuranceFragment();
        Bundle args = new Bundle();
        args.putParcelable("insurance", insurance);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            insurance = getArguments().getParcelable("insurance");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insurance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.fragmentInsName);
        price = view.findViewById(R.id.fragmentInsPrice);
        status = view.findViewById(R.id.fragmentInsStatus);
        compensation = view.findViewById(R.id.fragmentInsCompensation);

        btnCancel = view.findViewById(R.id.buttonCancel);
        btnSave = view.findViewById(R.id.buttonSave);

        name.setText(insurance.getInsuranceName().toString());
        price.setText(String.valueOf(insurance.getInsurancePrice()));
        status.setText(insurance.getInsuranceStatus());
        compensation.setText(String.valueOf(insurance.getInsuranceCompensation()));

        //status.setEnabled(false);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().remove(InsuranceFragment.this).commit();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insurance.setInsuranceName(name.getText().toString());
                insurance.setInsurancePrice(Double.parseDouble(price.getText().toString()));
                insurance.setInsuranceStatus(status.getText().toString());
                insurance.setInsuranceCompensation(Double.parseDouble(compensation.getText().toString()));

                if(listener != null){
                    listener.onInsuranceUpdated(insurance);
                }
            }
        });
    }

    public void setListener(OnInsuranceUpdatedListener listener) {
        this.listener = listener;
    }
}