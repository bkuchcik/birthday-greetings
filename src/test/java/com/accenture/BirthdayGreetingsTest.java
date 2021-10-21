package com.accenture;

import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayGreetingsTest {
    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyShouldbeAsExpected() throws MessagingException, IOException {
        LocalDate date = LocalDate.of(2021, 10, 20);
        Person john = new Person("John", "Jack", date, "john.jack@email.com");
        assertTrue(BirthdayGreetings.checkDates(john));

    }

    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyNotShouldbeAsExpected() throws MessagingException, IOException {
        LocalDate date = LocalDate.of(2020, 10, 19);
        Person mary = new Person("Mary", "Ann", date, "mary.ann@foobar.com");
        assertFalse(BirthdayGreetings.checkDates(mary));
    }
}