package com.accenture.birthday;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BirthdayTest {

    @Test
    public void whenTwoLocalDatesHaveSameMonthAndDayButYear_thenIsSameDayIgnoringYearShouldReturnTrue() {
        final var birthday = Birthday.of(LocalDate.of(2021, 10, 20));
        final var dateToTest = DayMonth.of(LocalDate.of(2021, 10, 20));
        Assertions.assertTrue(birthday.isBirthday(dateToTest));
    }

    @Test
    public void whenTwoLocalDatesHaveSameYearButMonthAndDay_thenIsSameDayIgnoringYearShouldReturnFalse() {
        final var birthday = Birthday.of(LocalDate.of(2021, 10, 20));
        final var dateToTest = DayMonth.of(LocalDate.of(2021, 10, 21));
        Assertions.assertFalse(birthday.isBirthday(dateToTest));
    }

    @Test
    public void whenTwoDateWithSameDayAndMonthWithOneLeapDate_thenIsSameDayIgnoringYearShouldReturnTrue() {
        final var birthday = Birthday.of(LocalDate.of(2024, 12, 31));
        final var dateToTest = DayMonth.of(LocalDate.of(2021, 12, 31));
        Assertions.assertTrue(birthday.isBirthday(dateToTest));
    }

    @Test
    public void whenBirthdateIs29FebruaryAndDateToTestIs1MarchOfLeapYear_thenIsBirthdayShouldReturnTrue() {
        final var birthday = Birthday.of(LocalDate.of(2024, 2, 29));
        final var dateToTest = DayMonth.of(LocalDate.of(2025, 3, 1));
        Assertions.assertTrue(birthday.isBirthday(dateToTest));
    }

    @Test
    public void whenBirthdateIs29FebruaryAndDateToTestIs5MarchOfLeapYear_thenIsBirthdayShouldReturnFalse() {
        final var birthday = Birthday.of(LocalDate.of(2024, 2, 29));
        final var dateToTest = DayMonth.of(LocalDate.of(2025, 3, 5));
        Assertions.assertFalse(birthday.isBirthday(dateToTest));
    }

    @Test
    public void whenBirthdateIs29FebruaryAndDateToTestIs29February_thenIsBirthdayShouldReturnTrue() {
        final var birthday = Birthday.of(LocalDate.of(2024, 2, 29));
        final var dateToTest = DayMonth.of(LocalDate.of(2028, 2, 29));
        Assertions.assertTrue(birthday.isBirthday(dateToTest));
    }

    @Test
    public void whenBirthdateIsToday_thenIsBirthdayShouldReturnTrue() {
        Birthday birthday = Birthday.of(LocalDate.now());
        Assertions.assertTrue(birthday.isTodayBirthday());
    }

    @Test
    public void whenBirthdateIsYesterday_thenIsBirthdayShouldReturnFalse() {
        Birthday birthday = Birthday.of(LocalDate.now().minusDays(1));
        Assertions.assertFalse(birthday.isTodayBirthday());
    }

}