package com.springCrud.crud.entity;

// Import JPA annotations for ORM (Object Relational Mapping)
import jakarta.persistence.*;

// Define this class as a JPA entity, representing a database table.
@Entity
@Table(name="student")
public class Student {

    // Define fields

    // Primary key field, auto-incremented by the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    // Field mapped to the "first_name" column in the database.
    @Column(name="first_name")
    private String firstName;

    // Field mapped to the "last_name" column in the database.
    @Column(name="last_name")
    private String lastName;

    // Field mapped to the "email" column in the database.
    @Column(name="email")
    private String email;

    // No-argument constructor (required by JPA)
    public Student() {
    }

    // Constructor with fields, useful for creating new Student instances
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter and setter methods for each field
    // Get the student's ID
    public int getId() {
        return id;
    }

    // Set the student's ID
    public void setId(int id) {
        this.id = id;
    }

    // Get the student's first name
    public String getFirstName() {
        return firstName;
    }

    // Set the student's first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Get the student's last name
    public String getLastName() {
        return lastName;
    }

    // Set the student's last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get the student's email
    public String getEmail() {
        return email;
    }

    // Set the student's email
    public void setEmail(String email) {
        this.email = email;
    }

    // Override toString method to return a readable representation of the Student object
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
