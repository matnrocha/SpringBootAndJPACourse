package com.mateus.springproject.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Constaining Return all objects which parameter is a substring
    List<Student> findAllByFirstNameContaining(String firstname);
}
