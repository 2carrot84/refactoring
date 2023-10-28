package com.example.study_refactoring.example.model;

public class ChildrenPrice extends Price {

    @Override
    int gePriceCode() {
        return Movie.CHILDREN;
    }
}
