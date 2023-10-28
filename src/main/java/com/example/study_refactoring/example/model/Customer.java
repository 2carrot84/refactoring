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
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + get_name() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += "\t" + each.get_movie().get_title() + "\t" +
                each.getCharge() + "\n";
        }

        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }
}
