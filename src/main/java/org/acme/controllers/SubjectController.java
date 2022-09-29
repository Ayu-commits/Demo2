package org.acme.controllers;

import org.acme.models.SubjectModel;
import org.acme.entities.Subject;
import org.acme.service.SubjectService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/subject")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class SubjectController {
    @Inject
    SubjectService subjectService;

    @POST
    @Transactional
    public SubjectModel createSubject(SubjectModel subject)
    {
        subject.setName(subject.getName());
        subjectService.createSubject(subject);
        return subject;
    }
    @PUT
    @Path("/{subjectId}/student/{studentId}")
    @Transactional
    public SubjectModel enrolledStudentToSubject(@PathParam("subjectId")Long sub_id,@PathParam("studentId") Long student_id)
    {
            SubjectModel obj = subjectService.enroll(sub_id,student_id);
            return obj;
    }



}
