package com.accenture.birthday;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class Birthday {
    private static final DayMonth FEBRUARY_29 = new DayMonth(29, Month.FEBRUARY, true);
    private static final DayMonth MARCH_1_NO_LEAP_YEAR = new DayMonth(1, Month.MARCH, false);

    private final int year;
    private final Month month;
    private final int dayOfMonth;
    private final boolean leapYear;

    private Birthday(int year, Month month, int dayOfMonth, boolean leapYear) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.leapYear = leapYear;
    }

    public boolean isBirthday(DayMonth dayMonthToTest) {
        if (FEBRUARY_29.equals(asDayMonth()) && !dayMonthToTest.isLeapYear()) {
            return MARCH_1_NO_LEAP_YEAR.equals(dayMonthToTest);
        }
        return asDayMonth().equals(dayMonthToTest);
    }

    public boolean isTodayBirthday() {
        return isBirthday(DayMonth.now());
    }

    private DayMonth asDayMonth() {
        return new DayMonth(this.dayOfMonth, this.month, this.leapYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return year == birthday.year && dayOfMonth == birthday.dayOfMonth && leapYear == birthday.leapYear && month == birthday.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, dayOfMonth, leapYear);
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "year=" + year +
                ", month=" + month +
                ", dayOfMonth=" + dayOfMonth +
                ", leapYear=" + leapYear +
                '}';
    }

    public static Birthday of(LocalDate birthDay) {
        return new Birthday(birthDay.getYear(), birthDay.getMonth(), birthDay.getDayOfMonth(), birthDay.isLeapYear());
    }

}
