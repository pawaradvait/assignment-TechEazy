package com.TechEazy.service;

import com.TechEazy.model.Student;

import java.util.List;

public interface StudentService {

   Student   addStudent( Student student );

   List<Student> getStudents();

   Student getstudent();
}
