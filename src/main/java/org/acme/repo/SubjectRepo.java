package org.acme.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entities.Subject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SubjectRepo implements PanacheRepository<Subject> {
}
