package com.mateus.springproject.student;

import com.mateus.springproject.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        //Mock the calls
        when(studentMapper.ToStudent(dto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(new Student(
                        "mateus",
                        "rocha",
                        "mateus@gmail.com",
                        21,
                        school
                ));
        when(studentMapper.toStudentResponseDto(student))
                .thenReturn(new StudentResponseDto(
                        "mateus",
                        "rocha",
                        "mateus@gmail.com"
                ));
        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);
        //Then
        assertEquals(responseDto.firstName(), dto.firstName());
        assertEquals(responseDto.lastName(), dto.lastName());
        assertEquals(responseDto.email(), dto.email());
        assertEquals(responseDto.firstName(), dto.firstName());
    }
}