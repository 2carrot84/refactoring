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

        Rental rental1 = new Rental(new Movie("movie1", Movie.REGULAR), 4);

        customer.addRental(rental1);

        assertThat(customer.statement()).isEqualTo("Rental Record for 2carrot\n"
            + "\tmovie1\t5.0\n"
            + "Amount owed is 5.0\n"
            + "You earned 1 frequent renter points");

        Rental rental2 = new Rental(new Movie("movie2", Movie.CHILDREN), 1);

        customer.addRental(rental2);

        assertThat(customer.statement()).isEqualTo("Rental Record for 2carrot\n"
            + "\tmovie1\t5.0\n"
            + "\tmovie2\t1.5\n"
            + "Amount owed is 6.5\n"
            + "You earned 2 frequent renter points");
    }

    @Test
    void htmlStatement() {
        Customer customer = new Customer("2carrot");
        assertThat(customer.htmlStatement()).isEqualTo(
            "<H1>Rental Record for <EM>2carrot</EM></H1><P>\n"
                + "<P>You owe <EM>0.0<EM><P>\n"
                + "On this rental you earned <EM>0</EM> frequent renter points<P>");

        Rental rental1 = new Rental(new Movie("movie1", Movie.REGULAR), 4);

        customer.addRental(rental1);
        assertThat(customer.htmlStatement()).isEqualTo(
            "<H1>Rental Record for <EM>2carrot</EM></H1><P>\n"
                + "movie1: 5.0<BR>\n"
                + "<P>You owe <EM>5.0<EM><P>\n"
                + "On this rental you earned <EM>1</EM> frequent renter points<P>");

        Rental rental2 = new Rental(new Movie("movie2", Movie.CHILDREN), 1);

        customer.addRental(rental2);
        assertThat(customer.htmlStatement()).isEqualTo(
            "<H1>Rental Record for <EM>2carrot</EM></H1><P>\n"
                + "movie1: 5.0<BR>\n"
                + "movie2: 1.5<BR>\n"
                + "<P>You owe <EM>6.5<EM><P>\n"
                + "On this rental you earned <EM>2</EM> frequent renter points<P>");
    }
}