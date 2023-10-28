package com.example.study_refactoring.example.model;

public class ChildrenPrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}
