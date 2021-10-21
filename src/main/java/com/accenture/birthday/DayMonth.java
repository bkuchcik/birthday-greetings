package com.accenture.birthday;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class DayMonth {
    private final int dayOfMonth;
    private final Month month;
    private final boolean leapYear;

    DayMonth(int dayOfMonth, Month month, boolean leapYear) {
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.leapYear = leapYear;
    }

    public boolean isLeapYear() {
        return leapYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayMonth dayMonth = (DayMonth) o;
        return dayOfMonth == dayMonth.dayOfMonth && month == dayMonth.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfMonth, month);
    }

    static DayMonth of(LocalDate localDate) {
        return new DayMonth(localDate.getDayOfMonth(), localDate.getMonth(), localDate.isLeapYear());
    }

    static DayMonth now() {
        return of(LocalDate.now());
    }
}