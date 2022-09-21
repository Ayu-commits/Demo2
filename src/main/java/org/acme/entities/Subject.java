package org.acme.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subName;


    @ManyToMany
    @JoinTable(
            name="student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name ="student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    public Subject() {
    }

    public Subject(Long id, String subName) {
        this.id = id;
        this.subName = subName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrolled(Student student) {
        enrolledStudents.add(student);
    }
}
