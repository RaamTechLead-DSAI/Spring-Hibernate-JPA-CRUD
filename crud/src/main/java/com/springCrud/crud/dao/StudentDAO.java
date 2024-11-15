package com.springCrud.crud.dao;

// Importing the Student entity for use in data access operations
import com.springCrud.crud.entity.Student;

import java.util.List;

// DAO (Data Access Object) interface for handling Student-related database operations
public interface StudentDAO {

    // Save a new student to the database or update an existing student's information
    void save(Student theStudent);

    // Find and return a student by their unique ID
    Student findById(Integer id);

    // Retrieve a list of all students from the database
    List<Student> finAll();

    // Find students based on their last name and return a list of matching results
    List<Student> findBylastName(String theLastname);

    // Update an existing student's information in the database
    void update(Student theStudent);

    // Delete a student by their unique ID
    void delete(Integer id);

    // Delete all students from the database, returning the number of records deleted
    int deleteAll();
}
