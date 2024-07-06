package com.mateus.springproject.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mateus.springproject.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_SCHOOL")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference       //plus @JsonBackReference prevents infinite looping
    private List<Student> students;

    public School() {
    }



    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
