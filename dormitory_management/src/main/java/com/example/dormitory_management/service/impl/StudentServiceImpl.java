package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.StudentDTO;
import com.example.dormitory_management.repository.StudentRepository;
import com.example.dormitory_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO room) {
        return null;
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO student) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public Optional<StudentDTO> getStudentById(Long studentId) {
        return Optional.empty();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of();
    }
}
