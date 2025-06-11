package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO createStudent(StudentDTO room);
    StudentDTO updateStudent(Long studentId, StudentDTO student);
    void deleteStudent(Long studentId);
    Optional<StudentDTO> getStudentById(Long studentId);
    List<StudentDTO> getAllStudents();
}