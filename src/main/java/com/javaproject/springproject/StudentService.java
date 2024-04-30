package com.javaproject.springproject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRespository respository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRespository respository, StudentMapper studentMapper) {
        this.respository = respository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = respository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents() {
        return respository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> findStudentsByName(String name) {
        return respository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer id) {
        return respository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        respository.deleteById(id);
    }
}
