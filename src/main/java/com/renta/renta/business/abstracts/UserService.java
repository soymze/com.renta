package com.renta.renta.business.abstracts;

import com.renta.renta.business.dtos.requests.user.UserCreateRequest;
import com.renta.renta.business.dtos.responses.UserResponse;
import com.renta.renta.entities.User;
import com.renta.renta.utilities.results.Result;

import java.util.Optional;

public interface UserService {

    Result createUser(UserCreateRequest userCreateRequest);

    Optional<User> getUserByUsername(String username);

    Optional<User> validUsernameAndPassword(String username, String password);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithMail(String mail);

    User saveUser(User user);

    UserResponse validateAndGetUserByUsername(String username);
}
