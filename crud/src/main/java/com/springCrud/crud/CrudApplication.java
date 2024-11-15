package com.springCrud.crud;

// Import necessary classes and annotations
import com.springCrud.crud.dao.StudentDAO;
import com.springCrud.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

// Main application class for the Spring Boot CRUD application
@SpringBootApplication
public class CrudApplication {

	// Entry point of the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	// CommandLineRunner bean to run the CRUD operations after application startup
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// Uncomment the desired operation(s) to perform specific CRUD actions
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	// Delete all student records from the database
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	// Delete a specific student by ID
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	// Update a student’s first name using their ID
	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// Update the student’s first name
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		// Save the updated student record
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);
	}

	// Query and display students by last name
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findBylastName("Lamb");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	// Query and display all students
	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.finAll();
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	// Create a new student and display the saved record
	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy.duck@testmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated ID: " + theId);

		// Retrieve and display student by ID
		System.out.println("Retrieving student with ID: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student: " + myStudent);
	}

	// Create and save multiple students to the database
	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating three new student objects ...");
		Student tempStudent1 = new Student("John", "Paul", "John.Paul@testmail.com");
		Student tempStudent2 = new Student("Bonita", "Applebum", "bonita.applebum@testmail.com");
		Student tempStudent3 = new Student("Mary", "Lamb", "Mary.Lamb@testmail.com");

		System.out.println("Saving the students ... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	// Create and save a single student to the database
	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul.doe@testmail.com");

		System.out.println("Saving the student ... ");
		studentDAO.save(tempStudent);
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
