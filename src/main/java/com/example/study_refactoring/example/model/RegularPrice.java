package com.example.study_refactoring.example.model;

public class RegularPrice extends Price {

    @Override
    int gePriceCode() {
        return Movie.REGULAR;
    }
}
