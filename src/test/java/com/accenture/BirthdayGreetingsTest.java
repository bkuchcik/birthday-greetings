package com.accenture;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayGreetingsTest {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();
    LocalDate date = localDate.of(2021,10,19);
    Person john = new Person("John", "Jack", date, "john.jack@email.com");
    @Test
    public void whenBirthdayOfJohnIsToday_thenMailBodyShouldbeAsExpected() {

       assertEquals(dtf.format(localDate),dtf.format(john.getDateOfBirth()));

    }
}