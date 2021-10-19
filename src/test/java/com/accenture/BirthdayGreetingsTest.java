package com.accenture;

import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayGreetingsTest {
    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyShouldbeAsExpected() throws MessagingException {
        LocalDate date = LocalDate.of(2021, 10, 19);
        LocalDate now = LocalDate.now();
        Person john = new Person("John", "Jack", date, "john.jack@email.com");
        assertTrue(BirthdayGreetings.checkDates(john, now));

    }

    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyNotShouldbeAsExpected() throws MessagingException {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2020, 10, 19);
        Person mary = new Person("Mary", "Ann", date, "mary.ann@foobar.com");
        assertFalse(BirthdayGreetings.checkDates(mary, now));

    }
}