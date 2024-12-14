package com.TechEazy.controller;

import com.TechEazy.model.Response;
import com.TechEazy.model.Student;
import com.TechEazy.model.Subject;
import com.TechEazy.repo.SubjectRepo;
import com.TechEazy.service.StudentService;
import com.TechEazy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectRepo subjectRepo;

    @PostMapping(value = "/api/student")
    public ResponseEntity<Response> addStudent(@RequestBody Student student ){
    Student student1 =studentService.addStudent(student);
    if(student1 == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("400", "student already exist"));
    }
   return ResponseEntity.status(200)
           .body(new Response("200","successfully created student"));
    }





}
