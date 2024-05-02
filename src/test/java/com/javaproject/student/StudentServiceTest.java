package com.javaproject.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StudentServiceTest {
    // which service is being testedas
    @InjectMocks
    private StudentService studentService;

    // declaring the dependencies
    @Mock
    private final StudentRespository respository;
    @Mock
    private final StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public StudentServiceTest(StudentRespository respository, StudentMapper studentMapper) {
        this.respository = respository;
        this.studentMapper = studentMapper;
    }

    @Test
    public void should_successfullly_save_a_student() {
        // given
        StudentDto dto = new StudentDto("Iain", "Mosima", "iainmosima@gmail2.com", 1);

        // Mock the calls
        // whem
        Student student = new Student("Iain", "Mosima", "iainmosima@gmai.com", 22);

        Student savedStudent = new Student("Iain", "Mosima", "iainmosima@gmail.com", 22);
        savedStudent.setId(1);

        when(studentMapper.toStudent(dto)).thenReturn(student);

        when(respository.save(student)).thenReturn(savedStudent);

        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto("Iain", "Mosima", "iainmosima@gmail.com"));
        // then
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(respository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(savedStudent);

    }
}
