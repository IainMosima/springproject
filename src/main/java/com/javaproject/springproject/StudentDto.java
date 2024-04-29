package com.javaproject.springproject;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer age,
        Integer schoolId) {

}
