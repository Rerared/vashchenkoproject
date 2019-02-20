package com.vashchenko.domain;

import java.util.Objects;

public class Client {

    private long id;
    private String name;
    private String surname;
    private int age;
    private String number;
    private String email;

    public Client() {
    }

    public Client(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public Client(String name, String surname, int age, String number, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.number = number;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Client client = (Client) o;
        return id == client.id &&
                age == client.age &&
                name.equals(client.name) &&
                surname.equals(client.surname) &&
                number.equals(client.number) &&
                email.equals(client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, number, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
