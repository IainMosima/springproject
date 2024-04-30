package com.javaproject.student;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(
            @PathVariable("student-name") String name) {
        return studentService.findStudentsByName(name);
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @Valid @RequestBody StudentDto dto) {
        return studentService.saveStudent(dto);
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(
            @PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @DeleteMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void Delete(
            @PathVariable("student-id") Integer id) {
        studentService.deleteById(id);
    }

}

// @PostMapping("/post-order")
// public String postOrder(
// @RequestBody Order order) {
// return "Request accepted and message is : " + order.toString();
// }

// // @GetMapping("/hello/{user-name}")
// public String pathVar(
// @PathVariable("user-name") String userName) {
// return "my value = " + userName;
// }

// @GetMapping("/hello")
// public String pathVar2(
// @RequestParam("firstname") String fisrtName,
// @RequestParam("lastname") String lastName) {
// return "my value = " + fisrtName + " " + lastName;
// }