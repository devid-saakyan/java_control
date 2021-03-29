package com.example.david_rest.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
public class PersonEntity {
    @Id
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String surname;
    private LocalDate birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getlogin() { return login; }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getsurname() { return surname; }

    public void setsurname(String surname) { this.surname = surname; }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


}