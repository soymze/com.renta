package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.UserService;
import com.renta.renta.business.dtos.requests.user.UserCreateRequest;
import com.renta.renta.business.dtos.responses.UserResponse;
import com.renta.renta.dataAccess.UserRepository;
import com.renta.renta.entities.User;
import com.renta.renta.exception.UserNotFoundException;
import com.renta.renta.utilities.mapping.ModelMapperManager;
import com.renta.renta.utilities.results.Result;
import com.renta.renta.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperManager modelMapperManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Result createUser(UserCreateRequest userCreateRequest) {
        User user = modelMapperManager.forRequest().map(userCreateRequest, User.class);

        userRepository.save(user);


        return new SuccessResult("successfully created");
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Optional<User> validUsernameAndPassword(String username, String password) {
        return getUserByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));    }

    @Override
    public boolean hasUserWithUsername(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.existsByMail(email);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserResponse validateAndGetUserByUsername(String username) {
        User user = getUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));

        return modelMapperManager.forResponse().map(user, UserResponse.class);
    }
}
