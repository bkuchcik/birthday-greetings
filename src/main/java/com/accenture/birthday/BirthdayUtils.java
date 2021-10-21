package com.accenture.birthday;

import java.time.LocalDate;

public class BirthdayUtils {

    private BirthdayUtils() {
    }

    public static boolean isBirthday(LocalDate birthDay, LocalDate dateToTest) {
        final var birthDayInDayOfMonth = Birthday.of(birthDay);
        final var dateToTestInDayOfMonth = DayMonth.of(dateToTest);
        return birthDayInDayOfMonth.isBirthday(dateToTestInDayOfMonth);
    }
}
