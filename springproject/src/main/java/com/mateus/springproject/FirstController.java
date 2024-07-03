package com.mateus.springproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {
    private final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        System.out.println(student.getAge());
        Student studentSaved = studentRepository.save(student);
        System.out.println(studentSaved.getId());
        return studentSaved;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student findStudentById(
            @PathVariable("studentId") Integer studentId
    ){
        return studentRepository.findById(studentId)
                .orElse(null);
    }

}
