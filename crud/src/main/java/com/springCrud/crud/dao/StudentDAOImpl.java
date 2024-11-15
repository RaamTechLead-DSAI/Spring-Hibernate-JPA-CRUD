package com.springCrud.crud.dao;

// Import necessary classes and annotations
import com.springCrud.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Mark this class as a repository to indicate it's a Data Access Object (DAO)
@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define a field for EntityManager to manage entity interactions
    private EntityManager entityManager;

    // Inject the EntityManager through constructor injection to ensure dependency is provided
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement the save method to persist a new Student entity to the database
    @Override
    @Transactional // Annotation to manage transaction boundaries
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    // Implement the findById method to fetch a Student entity by its ID
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // Implement the finAll method to retrieve all Student entities in ascending order by last name
    @Override
    public List<Student> finAll() {
        // Create a query to fetch all students, ordered by last name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        // Execute the query and return the result list
        return theQuery.getResultList();
    }

    // Implement the findByLastName method to retrieve students by last name
    @Override
    public List<Student> findBylastName(String theLastname) {
        // Create a query to fetch students with a specific last name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        // Set the last name parameter
        theQuery.setParameter("theData", theLastname);
        // Execute the query and return the result list
        return theQuery.getResultList();
    }

    // Implement the update method to merge changes to an existing Student entity
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    // Implement the delete method to remove a Student entity by its ID
    @Override
    @Transactional
    public void delete(Integer id) {
        // Find the student entity to delete
        Student theStudent = entityManager.find(Student.class, id);
        // Remove the entity from the database
        entityManager.remove(theStudent);
    }

    // Implement the deleteAll method to delete all Student entities from the database
    @Override
    @Transactional
    public int deleteAll() {
        // Execute an update query to delete all students, returning the number of rows affected
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
