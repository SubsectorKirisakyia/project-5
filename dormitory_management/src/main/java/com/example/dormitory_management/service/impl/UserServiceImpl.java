package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.UserDTO;
import com.example.dormitory_management.repository.UserRepository;
import com.example.dormitory_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO user) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}