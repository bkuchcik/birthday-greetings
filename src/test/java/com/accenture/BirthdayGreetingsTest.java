package com.accenture;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayGreetingsTest {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();

    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyShouldbeAsExpected() {
        LocalDate date = localDate.of(2021, 10, 19);
        Person john = new Person("John", "Jack", date, "john.jack@email.com");
        assertEquals(dtf.format(localDate), dtf.format(john.getDateOfBirth()));

    }

    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyNotShouldbeAsExpected() {
        LocalDate date = localDate.of(2020, 10, 19);
        Person mary = new Person("Mary", "Ann", date, "mary.ann@foobar.com");
        assertFalse(dtf.format(localDate) == dtf.format(mary.getDateOfBirth()));

    }
}