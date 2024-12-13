package com.TechEazy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjects" , fetch = FetchType.LAZY ,cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

 }
