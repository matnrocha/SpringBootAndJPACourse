package com.mateus.springproject.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "first name should not be empty")
        String firstName,
        @NotEmpty(message = "Last name should not be empty")
        String lastName,
        String email,
        Integer schoolId
) { }
