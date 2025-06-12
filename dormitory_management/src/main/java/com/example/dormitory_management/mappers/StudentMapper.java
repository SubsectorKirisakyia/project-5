package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.StudentDTO;
import com.example.dormitory_management.entity.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        if (student == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setFullName(student.getFullName());
        dto.setGender(student.getGender());
        dto.setDateOfBirth(student.getDateOfBirth());
        dto.setPhone(student.getPhone());
        dto.setEmail(student.getEmail());
        dto.setDepartment(student.getDepartment());
        dto.setStudentCode(student.getStudentCode());
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        if (dto == null) return null;

        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setFullName(dto.getFullName());
        student.setGender(dto.getGender());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());
        student.setStudentCode(dto.getStudentCode());
        return student;
    }
}
