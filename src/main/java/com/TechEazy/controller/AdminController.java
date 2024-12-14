package com.TechEazy.controller;

import com.TechEazy.model.Student;
import com.TechEazy.model.Subject;
import com.TechEazy.repo.SubjectRepo;
import com.TechEazy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectRepo subjectRepo;

    @GetMapping("/api/getAllStudents")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/api/getAllSubject")
    public ResponseEntity<List<Subject>> getSubjects() {
        List<Subject> subjects = subjectRepo.findAll();
        return ResponseEntity.ok(subjects);
    }

}
