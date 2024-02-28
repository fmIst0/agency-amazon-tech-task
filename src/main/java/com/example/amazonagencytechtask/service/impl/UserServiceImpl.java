package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.dto.UserRequestDto;
import com.example.amazonagencytechtask.dto.UserResponseDto;
import com.example.amazonagencytechtask.exception.RegistrationException;
import com.example.amazonagencytechtask.mapper.UserMapper;
import com.example.amazonagencytechtask.model.Role;
import com.example.amazonagencytechtask.model.db_collections.User;
import com.example.amazonagencytechtask.repository.UserRepository;
import com.example.amazonagencytechtask.service.UserService;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(UserRequestDto userRequestDto) throws RegistrationException {
        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new RegistrationException(
                    "User with email: " + userRequestDto.getEmail() + " already exists!"
            );
        }
        User newUser = new User();
        newUser.setEmail(userRequestDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        Role userRole = new Role().setRoleName(Role.RoleName.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        newUser.setRoles(roles);
        return userMapper.toUserResponse(userRepository.insert(newUser));
    }
}
