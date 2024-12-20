package com.TechEazy.service.impl;

import com.TechEazy.model.Student;
import com.TechEazy.repo.StudentRepo;
import com.TechEazy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Student addStudent(Student student) {

      Student student1 = studentRepo.findByEmail(student.getEmail());

      if(student1 != null){
          return null;
      }


       student.setPassword(passwordEncoder.encode(student.getPassword()));
       student.setRole("ROLE_STUDENT");
         studentRepo.save(student);

        return student;
    }

    @Override
    public List<Student> getStudents() {

        return studentRepo.findAll();
    }

    @Override
    public Student getstudent() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        studentRepo.findByEmail(authentication.getName());
        return studentRepo.findByEmail(authentication.getName());
    }
}
