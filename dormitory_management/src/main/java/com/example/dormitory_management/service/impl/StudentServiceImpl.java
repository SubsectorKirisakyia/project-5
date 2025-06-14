package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.StudentDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.Student;
import com.example.dormitory_management.exception.StudentCodeInUseException;
import com.example.dormitory_management.mappers.RoomMapper;
import com.example.dormitory_management.mappers.StudentMapper;
import com.example.dormitory_management.repository.StudentRepository;
import com.example.dormitory_management.service.StudentService;
import jakarta.persistence.EntityExistsException;
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
        if (studentRepository.findByStudentCode(dto.getStudentCode()).isEmpty()){
            Student student = StudentMapper.toEntity(dto);
            return StudentMapper.toDTO(studentRepository.save(student));
        }
        throw new StudentCodeInUseException("A student with the following code "+dto.getStudentCode()+" already exists, abort adding student.");
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO student) {
        Student existingStd = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student with the following ID does not exists: "+studentId));
        if (!student.getStudentCode().equals(existingStd.getStudentCode())) {
            studentRepository.findByStudentCode(student.getStudentCode())
                    .ifPresent(std -> {
                        if (!std.getStudentId().equals(existingStd.getStudentId())) {
                            String code = student.getStudentCode();
                            throw new StudentCodeInUseException("Student code "+code+" is already in use by another student");
                        }
                    });
        }
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
