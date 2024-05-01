package com.javaproject.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }
    
    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("Iain", "Mosima", "iainmosima@gmail.com", 1);
        Student student = mapper.toStudent(dto);
        
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        // given 
        Student student = new Student("Iain", "Mosima", "iainmosima@gmail.com", 22);
        // when
        StudentResponseDto response = mapper.toStudentResponseDto(student);

        // then
        assertEquals(student.getFirstname(), response.firstname());
        assertEquals(student.getLastname(), response.lastname());
        assertEquals(student.getEmail(), response.email());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student Dto should not be null", exp.getMessage());
        
    }
}

// @BeforeAll
// static void beforeAll() {
//     System.out.println("Inside the before all method");
// }

// @BeforeEach
// void setUp() {
//     System.out.println("Before each method");

// }

// @AfterEach
// void tearDown() {
//     System.out.println("Inside after each method");
// }

// @AfterAll
// static void afterAll() {
//     System.out.println("Inside the after all method");
// }

// @Test
// public void testMethod1() {
//     System.out.println("My 1st test method");
// }

// @Test
// public void testMethod2() {
//     System.out.println("My 2nd test method");
// }