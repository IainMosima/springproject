package com.javaproject.springproject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    private final StudentRespository respository;

    public FirstController(StudentRespository respository) {
        this.respository = respository;
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return respository.findAll();
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name") String name) {
                System.out.println(name);
        return respository.findAllByFirstnameContaining(name);
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student) {
        return respository.save(student);
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id) {
        return respository.findById(id).orElse(new Student());
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