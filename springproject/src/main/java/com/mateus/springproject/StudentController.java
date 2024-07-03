package com.mateus.springproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private Student ToStudent(StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto dto){
        var student = ToStudent(dto);
        var savedStudent = studentRepository.save(student);
        return toStudentResponseDto(savedStudent);
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

    @GetMapping("/students/search/{studentName}")
    public List<Student> findAllStudentsByFirstName(
            @PathVariable("studentName") String studentName
    ){
        return studentRepository.findAllByFirstNameContaining(studentName);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id){
        studentRepository.deleteById(id);
    }



}
