package com.TechEazy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String address;
    private String password;
    private String email;
    private String role;



    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(
        name = "person_subject",
        joinColumns = {
                @JoinColumn(name = "person_id" , referencedColumnName = "id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "subject_id" , referencedColumnName = "id")
        }
    )
    private Set<Subject> subjects = new HashSet<>();

}
