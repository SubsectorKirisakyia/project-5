package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(Long userId, UserDTO user);
    void deleteUser(Long userId);
    Optional<UserDTO> getUserById(Long userId);
    List<UserDTO> getAllUsers();
}
