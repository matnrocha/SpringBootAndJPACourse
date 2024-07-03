package com.mateus.springproject;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstName;
    private String lastName;
    @Column(
            name = "c_email",
            unique = true
    )
    private String email;
    private int age;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, int agr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = agr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
