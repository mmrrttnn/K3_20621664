package com.example.k3_20621664;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Insurance implements Parcelable {
    private String insuranceName;
    private double insurancePrice;
    private String insuranceStatus;
    private double insuranceCompensation;

    public Insurance(String insuranceName, double insurancePrice, String insuranceStatus, double insuranceCompensation) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.insuranceStatus = insuranceStatus;
        this.insuranceCompensation = insuranceCompensation;
    }

    protected Insurance(Parcel in) {
        insuranceName = in.readString();
        insurancePrice = in.readDouble();
        insuranceStatus = in.readString();
        insuranceCompensation = in.readDouble();
    }

    public static final Creator<Insurance> CREATOR = new Creator<Insurance>() {
        @Override
        public Insurance createFromParcel(Parcel in) {
            return new Insurance(in);
        }

        @Override
        public Insurance[] newArray(int size) {
            return new Insurance[size];
        }
    };

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public double getInsuranceCompensation() {
        return insuranceCompensation;
    }

    public void setInsuranceCompensation(double insuranceCompensation) {
        this.insuranceCompensation = insuranceCompensation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(insuranceName);
        parcel.writeDouble(insurancePrice);
        parcel.writeString(insuranceStatus);
        parcel.writeDouble(insuranceCompensation);
    }
}
