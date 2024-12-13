package com.TechEazy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {


    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjects" )
    private Set<Student> students = new HashSet<>();

 }
