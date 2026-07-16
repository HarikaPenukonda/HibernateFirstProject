package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(generator = "my_seq",strategy = GenerationType.AUTO) // MYSQL database, AUTO - if we dont know the DB, SEQUENCE - oracle
    @SequenceGenerator(name="my_seq", sequenceName = "My_OwnSequence", initialValue = 100, allocationSize = 1)
    private int id;

    private String name;

    private int age;

    private String email;

    // Default Constructor
    // Every Hibernate entity must have a no-argument (default) constructor. It can be public or protected.
    public Student() {
    	System.out.println("Zero parametrised constructor");
    }

    // Parameterized Constructor
    // This constructor is for our convenience, not for Hibernate.
    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}