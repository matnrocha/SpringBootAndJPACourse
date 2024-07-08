package com.mateus.springproject.student;

import com.mateus.springproject.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void should_return_all_students(){
        List<Student> students = new ArrayList<>();
        School school = new School("ufpe");
        students.add(new Student(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                21,
                school
        ));

        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto(
                "mateus",
                "rocha",
                "mateus@gmail.com"
        ));

        List<StudentResponseDto> dtos = studentService.findAllStudents();

        assertEquals(students.size(), dtos.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id(){
        Integer studentId = 1;
        School school = new School("ufpe");
        Student student = new Student(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                21,
                school
        );

        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "mateus",
                        "rocha",
                        "mateus@gmail.com"
                ));

        StudentResponseDto dto = studentService.findStudentById(studentId);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());

        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void should_find_list_of_students_by_first_name(){
        String studentName = "mateus";
        List<Student> students = new ArrayList<>();

        School school = new School("ufpe");
        Student student1 = new Student(
                "mateus",
                "rocha",
                "mateus@gmail.com",
                21,
                school
        );
        Student student2 = new Student(
                "mateuso",
                "rocha",
                "mateusrocha@gmail.com",
                23,
                school
        );

        students.add(student1);
        students.add(student2);

        when(studentRepository.findAllByFirstNameContaining(studentName))
                .thenReturn(students);

        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "mateus",
                        "rocha",
                        "mateus@gmail.com"
                ));

        List<StudentResponseDto> dtos = studentService.findAllStudentsByFirstName(studentName);

        assertEquals(dtos.size(), students.size());
        verify(studentRepository, times(1)).findAllByFirstNameContaining(studentName);
    }

    @Test
    public void should_delete_student_by_id(){
        Integer id = 1;
        Student student = new Student(
                "mateuso",
                "rocha",
                "mateusrocha@gmail.com",
                23,
                new School("ufpe")
        );

        when(studentRepository.deleteById(id))
                .thenReturn();

        studentService.delete(id);
        
        verify(studentRepository, times(1)).findById(id);
    }
}