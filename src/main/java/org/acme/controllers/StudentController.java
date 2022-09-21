package org.acme.controllers;

import org.acme.entities.Student;
import org.acme.service.StudentService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {


    @Inject
    StudentService studentService;

    @POST
    @Transactional
    public Student addStudent(Student student){
        Student obj = new Student();
        return obj;

    }
}
