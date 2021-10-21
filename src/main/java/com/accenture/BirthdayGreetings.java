package com.accenture;

import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class BirthdayGreetings {
    public List<Person> recupererListeAmis() throws IOException {

        Path path = Paths.get("listeContacts.txt");
        Scanner scanner = new Scanner(path);
        //System.out.println("Read text file using Scanner");
        List<Person> listAmis = new ArrayList<Person>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] ami = line.split(",");
            Person person = new Person(ami[0], ami[1], LocalDate.parse(ami[2]), ami[3]);
            listAmis.add(person);
        }
        scanner.close();
        return listAmis;

    }

    static public boolean checkDates(Person person) throws MessagingException, IOException {
        LocalDate currentDate = LocalDate.now();
        Instant instantBirth = person.getDateOfBirth().atStartOfDay(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.DAYS);
        Instant instantCurrent = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant().truncatedTo(ChronoUnit.DAYS);

        if (instantBirth.equals(instantCurrent)) {
            System.out.println("Happy Birthday " + person.getFirstname() + "!");
            return true;
        }
        return false;
    }


    public void whoSbirthday() throws IOException, MessagingException {
        List<Person> amis = recupererListeAmis();
        for (Person p : amis) {
            checkDates(p);
        }


    }
}
