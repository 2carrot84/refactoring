package com.example.study_refactoring.example.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void statement() {
        Customer customer = new Customer("2carrot");
        assertThat(customer.statement()).isEqualTo("Rental Record for 2carrot\n"
            + "Amount owed is 0.0\n"
            + "You earned 0 frequent renter points");

        Rental rental = new Rental(new Movie("movie1", Movie.REGULAR), 4);

        customer.addRental(rental);

        assertThat(customer.statement()).isEqualTo("Rental Record for 2carrot\n"
            + "\tmovie1\t5.0\n"
            + "Amount owed is 5.0\n"
            + "You earned 1 frequent renter points");
    }
}