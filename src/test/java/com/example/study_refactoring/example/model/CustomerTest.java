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
    }
}