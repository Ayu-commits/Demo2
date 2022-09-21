package org.acme.repo;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

import org.acme.entities.Student;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {

}
