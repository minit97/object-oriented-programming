package com.example.object_oriented.encapsulation.practice02;

public class Movie {
    public static int REGULAR = 0;
    public static int NEW_RELEASE = 1;
    private int priceCode;

    public int getFrequentRenterPoints(int daysRented) {
        if(priceCode == NEW_RELEASE && daysRented > 1) return 2;
        else return 1;
    }

}
