package com.mateus.springproject.student;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) { }
