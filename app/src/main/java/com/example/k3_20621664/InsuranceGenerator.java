package com.example.k3_20621664;

import java.util.ArrayList;
import java.util.Random;

public class InsuranceGenerator {
    public static ArrayList<Insurance> generateList(int count, String insuranceType){
        ArrayList<Insurance> items = new ArrayList<>();
        Random random = new Random();
        for(int i = 1; i <= count; i++) {
            String type = insuranceType + 1;
            items.add(new Insurance(type, 10L + random.nextDouble() % 99L, "Active", 10L + random.nextDouble() % 99L));
        }
        return items;
    }
}
