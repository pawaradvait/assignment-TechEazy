package com.TechEazy.repo;

import com.TechEazy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
   Student findByEmail(String name);
}
