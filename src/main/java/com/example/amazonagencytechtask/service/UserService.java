package com.example.amazonagencytechtask.service;

import com.example.amazonagencytechtask.dto.UserRequestDto;
import com.example.amazonagencytechtask.dto.UserResponseDto;
import com.example.amazonagencytechtask.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRequestDto userRequestDto) throws RegistrationException;
}
