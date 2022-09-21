package org.acme.service;

import org.acme.entities.Student;
import org.acme.entities.Subject;
import org.acme.repo.StudentRepo;
import org.acme.repo.SubjectRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SubjectService {
    @Inject
    SubjectRepo subjectRepo;
    @Inject
    StudentRepo studentRepo;


    public Subject createSubject(Subject subject)
    {
        subjectRepo.persist(subject);
        return subject;
    }


    public Subject enroll(Long id,Long Id)
    {
        Subject subject = subjectRepo.findById(id);
        Student student = studentRepo.findById(Id);
        subject.enrolled(student);
         subjectRepo.persist(subject);
         return subject;

    }
}
