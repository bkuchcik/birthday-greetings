package com.accenture;

import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException, MessagingException {
    BirthdayGreetings birthday= new BirthdayGreetings();
        birthday.whoSbirthday();

    }
}
