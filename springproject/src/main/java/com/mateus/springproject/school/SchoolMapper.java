package com.mateus.springproject.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto dto) { return new School(dto.name()); }

    public SchoolDto toSchoolDto(School school) {
        var dto = new SchoolDto(
                school.getName()
        );
        return dto;
    }
}
