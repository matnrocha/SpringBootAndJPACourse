package com.mateus.springproject.student;

import com.mateus.springproject.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private StudentRepository studentRepository;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student(){
        //Given
        StudentDto dto = new StudentDto(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                1
        );

        School school = new School("ufpe");
        Student student = new Student(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                21,
                school
        );

        Student savedStudent = new Student(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                21,
                school
        );
        //Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "mateus",
                        "rocha",
                        "mateus@gmail.com"
                ));
        //When
        StudentResponseDto resp = studentService.saveStudent(dto);
        //Then
        assertEquals(resp.firstName(), dto.firstName());
        assertEquals(resp.lastName(), dto.lastName());
        assertEquals(resp.email(), dto.email());
        assertEquals(resp.firstName(), dto.firstName());
        //Performance tests
        verify(studentMapper, times(1))
                .toStudent(dto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);
    }
}