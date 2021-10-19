package com.accenture;

import javax.mail.MessagingException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthdayGreetings {
    /* static public boolean checkDates(LocalDate birthDate, LocalDate currentDate) {
        Instant instantBirth = birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.DAYS);
        Instant instantCurrent = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.DAYS);
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if (instantBirth.equals(instantCurrent)) {
            return true;
        }
        return false;
    } */
    static public boolean checkDates(Person person, LocalDate currentDate) throws MessagingException {
        Instant instantBirth = person.getDateOfBirth().atStartOfDay(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.DAYS);
        Instant instantCurrent = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.DAYS);
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if (instantBirth.equals(instantCurrent)) {
            Mail mailer = new Mail();
            mailer.sendMail(person);
            return true;
        }
        return false;
    }

}
