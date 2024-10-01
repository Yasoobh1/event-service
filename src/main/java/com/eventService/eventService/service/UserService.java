package com.eventService.eventService.service;

import com.eventService.eventService.dto.UserRequest;
import com.eventService.eventService.model.UserEntity;
import com.eventService.eventService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Convert UserEntity to UserDTO
    private UserRequest convertToDTO(UserEntity userEntity) {
        UserRequest userDTO = new UserRequest();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }

    // Convert UserDTO to UserEntity
    private UserEntity convertToEntity(UserRequest userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setEmail(userDTO.getEmail());
        return userEntity;
    }

    // Create a new user
    public UserRequest createUser(UserRequest userDTO) {
        UserEntity userEntity = convertToEntity(userDTO);
        UserEntity savedUser = userRepository.save(userEntity);
        return convertToDTO(savedUser);
    }

    // Get a user by ID
    public UserRequest getUserById(Long id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        return userOpt.map(this::convertToDTO).orElse(null);
    }

    // Update user by ID
    public UserRequest updateUser(Long id, UserRequest userDTO) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            UserEntity existingUser = userOpt.get();
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            UserEntity updatedUser = userRepository.save(existingUser);
            return convertToDTO(updatedUser);
        }
        return null;
    }

    // Get all users
    public List<UserRequest> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Delete user by ID
    public boolean deleteUser(Long id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
