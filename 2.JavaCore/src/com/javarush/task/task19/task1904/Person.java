package com.javarush.task.task19.task1904;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        String data = format.format(birthDate);
        return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
    }
}
