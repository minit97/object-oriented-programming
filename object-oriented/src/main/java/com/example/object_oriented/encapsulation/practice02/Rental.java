package com.example.object_oriented.encapsulation.practice02;

public class Rental {
    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        if(movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) return 2;
        else return 1;
    }
}
