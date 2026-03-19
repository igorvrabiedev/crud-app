package com.example.crud_app;

import com.example.crud_app.dao.StudentDAO;
import com.example.crud_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

//        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//        };

        return runner -> {
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
    }

//    private void createStudent(StudentDAO studentDAO) {
//        // create Student object
//        System.out.println("Creating new student object ...");
//        Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");
//
//        // save Student object in database with DAO
//        System.out.println("Saving the student ...");
//        studentDAO.save(newStudent);
//
//        // show ID in saved student
//        System.out.println("Saved student. Generated id: " + newStudent.getId());
//    }

//    private void createMultipleStudents(StudentDAO studentDao) {
//        System.out.println("Creating 3 student objects ...");
//        Student newStudent1 = new Student("Ion", "Vasilachi", "vasilachi@GMAIL.COM");
//        Student newStudent2 = new Student("Maria", "Ionescu", "maria@GMAIL.COM");
//        Student newStudent3 = new Student("Andrei", "Vatrici", "andrei@GMAIL.COM");
//
//        System.out.println("Saving the student ..");
//        studentDao.save(newStudent1);
//        studentDao.save(newStudent2);
//        studentDao.save(newStudent3);
//    }

    private void readStudent(StudentDAO studentDAO) {
        // create an object Student type
        System.out.println("Creating new student object ...");
        Student newStudent = new Student("Mircea", "Popescu", "Mircea@gmail.com");

        // save Student in database
        System.out.println("Saving the student ...");
        studentDAO.save(newStudent);

        // show saved Student ID
        int theId = newStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // Recover Student in base of ID
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // show Student details
        System.out.println("Found the student: " + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // Obtain student list
        List<Student> theStudents = studentDAO.findAll();

        // Show the list of students
        for (Student newStudent : theStudents) {
            System.out.println(newStudent);
        }
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {
        List<Student> theStudent = studentDAO.findByLastName("Popescu");

        for(Student newStudent : theStudent);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // find student ID in database
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student newStudent = studentDAO.findById(studentId);

        // modify student surname in "Ion"
        System.out.println("Updating student ...");
        newStudent.setFirstName("Ion");

        // save modifications in database
        studentDAO.update(newStudent);

        // show details of the updated student
        System.out.println("Update student: " + newStudent);
    }

}