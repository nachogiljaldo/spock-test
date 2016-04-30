package com.gilsoft.user;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;

    public User(String firstName, String lastName, LocalDate birthDay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getAge() {
        return now().getYear() - birthDay.getYear() + ((now().isBefore(birthDay.withYear(now().getYear()))) ? -1 : 0);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
