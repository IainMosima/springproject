package com.javaproject.springproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student, Integer> {
    
}
