package com.example.amazonagencytechtask.controller;

import com.example.amazonagencytechtask.dto.UserLoginResponseDto;
import com.example.amazonagencytechtask.dto.UserRequestDto;
import com.example.amazonagencytechtask.dto.UserResponseDto;
import com.example.amazonagencytechtask.exception.RegistrationException;
import com.example.amazonagencytechtask.service.UserService;
import com.example.amazonagencytechtask.service.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserLoginResponseDto login(@RequestBody @Valid UserRequestDto userRequestDto) {
        return authenticationService.authenticate(userRequestDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody @Valid UserRequestDto userRequestDto)
            throws RegistrationException {
        return userService.register(userRequestDto);
    }
}
