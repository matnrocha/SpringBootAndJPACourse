package com.mateus.springproject;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) { }
