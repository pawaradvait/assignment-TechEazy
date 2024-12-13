package com.TechEazy.service.impl;

import com.TechEazy.model.Student;
import com.TechEazy.repo.StudentRepo;
import com.TechEazy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Student addStudent(Student student) {

       student.setPassword(passwordEncoder.encode(student.getPassword()));
       student.setRole("ROLE_STUDENT");
         studentRepo.save(student);

        return student;
    }
}
