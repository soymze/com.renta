package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.UserService;
import com.renta.renta.business.dtos.requests.user.UserCreateRequest;
import com.renta.renta.dataAccess.UserRepository;
import com.renta.renta.entities.User;
import com.renta.renta.utilities.mapping.ModelMapperManager;
import com.renta.renta.utilities.results.Result;
import com.renta.renta.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperManager modelMapperManager;
    @Override
    public Result createUser(UserCreateRequest userCreateRequest) {
        User user = modelMapperManager.forRequest().map(userCreateRequest, User.class);

        userRepository.save(user);


        return new SuccessResult("successfully created");
    }

    public User getById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user could not be found."));
    }
}
