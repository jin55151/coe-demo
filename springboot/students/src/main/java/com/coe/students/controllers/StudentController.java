package com.coe.students.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coe.students.dao.StudentDAO;
import com.coe.students.models.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
    // Inject DAO implementation (Repository)
    private final StudentDAO studentRepository;

    public StudentController(StudentDAO injectedStudentDAO) {
        studentRepository = injectedStudentDAO;
    }

    @PostMapping("/create")
    public String create(@RequestBody Student newStudent) {
        studentRepository.Save(newStudent);

        return "Created";
    }

    @RequestMapping("/get/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentRepository.findById(id);
    }
}
