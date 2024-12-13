package com.TechEazy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    private int id;
    private String name;
    private String address;

    @JoinTable(
        name = "person_subject",
        joinColumns = @JoinColumn(name = "person_id" , referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id" , referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<>();

}
