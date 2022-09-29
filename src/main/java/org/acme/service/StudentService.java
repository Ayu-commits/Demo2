package org.acme.service;

import org.acme.models.StudentModel;
import org.acme.entities.Student;
import org.acme.repo.StudentRepo;
import org.acme.repo.SubjectRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StudentService {
    @Inject
    StudentRepo studentRepo;
    @Inject
    SubjectRepo subjectRepo;

    public StudentModel createStudent(StudentModel student)
    {

        Student stud = StudentModelToUser(student);
        studentRepo.persist(stud);
        return StudentUserToModel(stud);
    }

    public StudentModel getDetails(Long id) {
        Student student= new Student();
        try{
             student = studentRepo.findById(id);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  StudentUserToModel(student) ;
    }

    public Student StudentModelToUser(StudentModel obj){
        Student student =new Student();
        student.setName(obj.getName());
        return student;
    }
    public StudentModel StudentUserToModel(Student student)
    {
            StudentModel studentModel = new StudentModel();
            studentModel.setName(student.getName());
            return studentModel;
    }




}
