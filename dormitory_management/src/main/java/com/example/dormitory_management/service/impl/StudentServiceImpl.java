package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.StudentDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.Student;
import com.example.dormitory_management.mappers.RoomMapper;
import com.example.dormitory_management.mappers.StudentMapper;
import com.example.dormitory_management.repository.StudentRepository;
import com.example.dormitory_management.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        return StudentMapper.toDTO(studentRepository.save(student));
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO student) {
        Student existingStd = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student with the following ID does not exists: "+studentId));
        existingStd.setStudentCode(student.getStudentCode());
        existingStd.setDepartment(student.getDepartment());
        existingStd.setEmail(student.getEmail());
        existingStd.setGender(student.getGender());
        existingStd.setPhone(student.getPhone());
        existingStd.setFullName(student.getFullName());
        existingStd.setDateOfBirth(student.getDateOfBirth());
        return StudentMapper.toDTO(studentRepository.save(existingStd));
    }

    @Override
    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new EntityNotFoundException("Student not found with ID: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    public Optional<StudentDTO> getStudentById(Long studentId) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student was not found with ID: " + studentId));
        return Optional.of(StudentMapper.toDTO(student));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream().map(StudentMapper::toDTO).collect(Collectors.toList());
    }
}
