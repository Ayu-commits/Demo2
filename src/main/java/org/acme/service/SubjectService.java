package org.acme.service;

import org.acme.entities.Student;
import org.acme.entities.Subject;
import org.acme.models.SubjectModel;
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


    public SubjectModel createSubject(SubjectModel subject)
    {
        Subject subject1 = new Subject();
        subject1.setSubName(subject.getName());
        subjectRepo.persist(subject1);
        return subject;
    }


    public SubjectModel enroll(Long id,Long Id)
    {
        //SubjectModel obj = new SubjectModel();
        Subject subject = subjectRepo.findById(id);
        Student student = studentRepo.findById(Id);
        subject.enrolled(student);
         subjectRepo.persist(subject);
         return toSubjectModel(subject);

    }

    public SubjectModel toSubjectModel(Subject obj){
        SubjectModel model = new SubjectModel();
        model.setName(obj.getSubName());
        return model;
    }

    public Subject toSubjectUser(SubjectModel obj)
    {
        Subject sub = new Subject();
        sub.setSubName(obj.getName());
        return sub;
    }
}
