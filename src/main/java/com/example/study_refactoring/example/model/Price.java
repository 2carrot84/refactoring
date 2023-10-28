package com.example.study_refactoring.example.model;

abstract public class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}
