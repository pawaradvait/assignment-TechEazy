package com.TechEazy.repo;

import com.TechEazy.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {


    Optional<Subject> findByName(String name);
}
