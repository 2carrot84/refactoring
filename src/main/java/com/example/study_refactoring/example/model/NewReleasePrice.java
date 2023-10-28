package com.example.study_refactoring.example.model;

public class NewReleasePrice extends Price {

    @Override
    int gePriceCode() {
        return Movie.NEW_RELEASE;
    }
}
