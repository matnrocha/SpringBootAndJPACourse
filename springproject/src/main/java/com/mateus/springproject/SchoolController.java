package com.mateus.springproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private SchoolRepository schoolRepository;


    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
        var school = toSchool(dto);
        School savedSchool = schoolRepository.save(school);
        return dto;
    }

    private School toSchool(SchoolDto dto) { return new School(dto.name()); }

    private SchoolDto toSchoolDto(School school) {
        var dto = new SchoolDto(
                school.getName()
        );
        return dto;
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){

        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }
}
