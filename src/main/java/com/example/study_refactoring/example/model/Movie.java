package com.example.study_refactoring.example.model;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        set_priceCode(_priceCode);
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _price.gePriceCode();
    }

    public void set_priceCode(int arg) {
        switch (arg) {
            case Movie.REGULAR:
                _price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                _price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("incorrect Price Code");
        }
    }

    public double getCharge(int daysRented) {
        int result = 0;

        switch (get_priceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if ((get_priceCode() == Movie.NEW_RELEASE)
            && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
