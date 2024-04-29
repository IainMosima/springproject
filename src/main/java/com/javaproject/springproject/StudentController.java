package com.javaproject.springproject;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentRespository respository;

    public StudentController(StudentRespository respository) {
        this.respository = respository;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return respository.findAll();
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name") String name) {
        return respository.findAllByFirstnameContaining(name);
    }

    @PostMapping("/students")
    public StudentResponseDto post(
            @RequestBody StudentDto dto) {
        var student = toStudent(dto);
        var savedStudent = respository.save(student);
        return toStudentResponseDto(savedStudent);
    }


    private Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        student.setAge(dto.age());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getAge()

        );
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id) {
        return respository.findById(id).orElse(new Student());
    }

    @DeleteMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void Delete(
            @PathVariable("student-id") Integer id) {
        respository.deleteById(id);
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