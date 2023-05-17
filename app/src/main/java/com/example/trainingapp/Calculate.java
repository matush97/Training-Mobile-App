package com.example.trainingapp;

public class Calculate {

    public static double barbellWeight, numberRepeating;

    public static String maxWeight() {

        double value2 = 0.0333;

        double maxWeightResult =  barbellWeight * (1 + (value2 * numberRepeating));

        String result = String.valueOf(maxWeightResult);
        return result;
    }
}
