package com.gilsoft.user;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.LocalDate.now;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate birthDay;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, LocalDate birthDay) {
        this(firstName, lastName, birthDay);
        this.id = id;
    }

    public User(String firstName, String lastName, LocalDate birthDay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
