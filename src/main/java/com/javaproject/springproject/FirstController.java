package com.javaproject.springproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    // @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message) {
        return "Request accepted and message is : " + message;
    }

    @PostMapping("/post-order")
    public String postOrder(
            @RequestBody Order order) {
        return "Request accepted and message is : " + order.toString();
    }

    // @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName) {
        return "my value = " + userName;
    }

    @GetMapping("/hello")
    public String pathVar2(
            @RequestParam("firstname") String fisrtName,
            @RequestParam("lastname") String lastName) {
        return "my value = " + fisrtName + " " + lastName;
    }
}
