package org.acme.controllers;

import org.acme.models.StudentModel;
import org.acme.service.StudentService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/api/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {


    @Inject
    StudentService studentService;


    @POST
    @Transactional
    public StudentModel addStudent(StudentModel studentModel){

        studentService.createStudent(studentModel);
        return studentModel;
    }

    @GET
    @Path("{id}")
    @Transactional
    public StudentModel getDetails(@PathParam("id") Long studentId)
    {
        StudentModel studentModel = null;
        try{
             studentModel = studentService.getDetails(studentId);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return studentModel;
    }
}
