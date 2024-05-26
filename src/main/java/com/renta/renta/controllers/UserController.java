package com.renta.renta.controllers;

import com.renta.renta.business.abstracts.MessageService;
import com.renta.renta.business.abstracts.UserService;
import com.renta.renta.business.dtos.requests.message.MessageCreateRequest;
import com.renta.renta.business.dtos.requests.user.UserCreateRequest;
import com.renta.renta.utilities.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<Result> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {

        Result result = userService.createUser(userCreateRequest);

        return ResponseEntity.ok().body(result);
    }
}
