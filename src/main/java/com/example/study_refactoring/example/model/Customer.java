package com.example.study_refactoring.example.model;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Vector get_rentals() {
        return _rentals;
    }

    public void set_rentals(Vector<Rental> _rentals) {
        this._rentals = _rentals;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> retals = _rentals.elements();
        String result = "Rental Record for " + get_name() + "\n";

        while (retals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = retals.nextElement();

            thisAmount = amountFor(each);

            frequentRenterPoints++;
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE)
                && each.get_daysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.get_movie().get_title() + "\t" +
                String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent reter points";

        return result;
    }

    private double amountFor(Rental each) {
        int thisAmount = 0;

        switch (each.get_movie().get_priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.get_daysRented() > 2) {
                    thisAmount += (each.get_daysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.get_daysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (each.get_daysRented() > 3) {
                    thisAmount += (each.get_daysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}
