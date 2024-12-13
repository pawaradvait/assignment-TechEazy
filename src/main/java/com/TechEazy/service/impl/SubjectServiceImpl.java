package com.TechEazy.service.impl;

import com.TechEazy.model.Student;
import com.TechEazy.model.Subject;
import com.TechEazy.repo.StudentRepo;
import com.TechEazy.repo.SubjectRepo;
import com.TechEazy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Subject addSubjecttoStudent(String name) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Student s = studentRepo.findByEmail(authentication.getName());
           Subject ss= subjectRepo.findByName(name);
      s.getSubjects().add(subjectRepo.findByName(name));
studentRepo.save(s);
return ss;


        }
        return null;

    }
}
