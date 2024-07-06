package com.mateus.springproject.student;

import com.mateus.springproject.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void should_map_StudentDto_to_Student(){
        StudentDto dto = new StudentDto(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                1
        );

        Student student = mapper.ToStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_map_Student_to_StudentResponseDto(){
        //Given
        School school = new School("ufpe");
        Student student = new Student(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                21,
                school
        );

        //When
        StudentResponseDto dto = mapper.toStudentResponseDto(student);

        //Then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
    }

    @Test
    public void should_throw_NullPointerException_when_dto_is_null(){
        var exp = assertThrows(NullPointerException.class, () -> {
            mapper.ToStudent(null);
        });

        assertEquals("dto should not be null", exp.getMessage());
    }


}