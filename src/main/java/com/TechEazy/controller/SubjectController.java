package com.TechEazy.controller;

import com.TechEazy.model.Response;
import com.TechEazy.model.Subject;
import com.TechEazy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/api/subject")
    public ResponseEntity<Response> addSubject(@RequestParam(name = "name") String subject){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            subjectService.addSubject(subject);
            return ResponseEntity.status(200).body(new Response("200","successfully created subject"));
        }
        return ResponseEntity.status(401).body(new Response("401","unauthorized"));
    }

}
