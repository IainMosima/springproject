package com.javaproject.student;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email,
        int age) {

}
