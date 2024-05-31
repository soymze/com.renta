package com.renta.renta.controllers;

import com.renta.renta.business.abstracts.UserService;
import com.renta.renta.controllers.dto.AuthResponse;
import com.renta.renta.controllers.dto.LoginRequest;
import com.renta.renta.controllers.dto.SignUpRequest;
import com.renta.renta.entities.User;
import com.renta.renta.exception.DuplicatedUserInfoException;
import com.renta.renta.security.WebSecurityConfig;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userService.validUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(Long.valueOf(user.getId()), user.getUserName(), user.getRole()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.hasUserWithUsername(signUpRequest.getUsername())) {
            throw new DuplicatedUserInfoException(String.format("Username %s is already been used", signUpRequest.getUsername()));
        }
        if (userService.hasUserWithEmail(signUpRequest.getEmail())) {
            throw new DuplicatedUserInfoException(String.format("Email %s is already been used", signUpRequest.getEmail()));
        }

        User user = userService.saveUser(createUser(signUpRequest));
        return new AuthResponse(Long.valueOf(user.getId()), user.getUserName(), user.getRole());
    }

    private User createUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUserName(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        //user.setName(signUpRequest.getName());
        user.setMail(signUpRequest.getEmail());
        user.setRole(WebSecurityConfig.USER);
        return user;
    }
}