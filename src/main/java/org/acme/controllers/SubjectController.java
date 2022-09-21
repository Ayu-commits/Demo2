package org.acme.controllers;

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
    public Subject createSubject(Subject subject)
    {
        Subject obj = new Subject();
        obj.setSubName(subject.getSubName());
        subjectService.createSubject(obj);
        return obj;
    }

    @PUT
    @Path("/{subjectId}/student/{studentId}")
    @Transactional
    public Subject enrolledStudentToSubject(@PathParam("id")Long sub_id,@PathParam("Id") Long student_id)
    {
            Subject obj = subjectService.enroll(sub_id,student_id);
            return obj;
    }

}
