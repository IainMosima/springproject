package com.javaproject.springproject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMaper schoolMaper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMaper schoolMaper) {
        this.schoolRepository = schoolRepository;
        this.schoolMaper = schoolMaper;
    }

    public SchoolDto createNewSchool(SchoolDto dto) {
        var school = schoolMaper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMaper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
