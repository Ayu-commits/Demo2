package org.acme.service;

import org.acme.entities.Student;
import org.acme.repo.StudentRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StudentService {
    @Inject
    StudentRepo studentRepo;

    Student createStudent(Student student)
    {
        studentRepo.persist(student);
        return student;
    }
}
