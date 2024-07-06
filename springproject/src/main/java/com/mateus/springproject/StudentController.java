package com.mateus.springproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto dto){
        return studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public StudentResponseDto findStudentById(
            @PathVariable("studentId") Integer studentId
    ){
        return studentService.findStudentById(studentId);
    }

    @GetMapping("/students/search/{studentName}")
    public List<StudentResponseDto> findAllStudentsByFirstName(
            @PathVariable("studentName") String studentName
    ){
        return studentService.findAllStudentsByFirstName(studentName);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id){
        studentService.delete(id);
    }



}
