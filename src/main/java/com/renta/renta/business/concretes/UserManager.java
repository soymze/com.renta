package com.renta.renta.business.concretes;

import com.renta.renta.business.abstracts.UserService;
import com.renta.renta.business.dtos.requests.credentials.CredentialsDto;
import com.renta.renta.business.dtos.requests.user.UserCreateRequest;
import com.renta.renta.business.dtos.requests.user.UserDto;
import com.renta.renta.dataAccess.UserRepository;
import com.renta.renta.entities.User;
import com.renta.renta.exceptions.AppException;
import com.renta.renta.utilities.mapping.ModelMapperManager;
import com.renta.renta.utilities.results.Result;
import com.renta.renta.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperManager modelMapperManager;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Result createUser(UserCreateRequest userCreateRequest) {
        User user = modelMapperManager.forRequest().map(userCreateRequest, User.class);
        userRepository.save(user);
        return new SuccessResult("successfully created");
    }

    public User getById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user could not be found."));
    }

    public UserDto login(CredentialsDto credentailsDto){
        User user = userRepository.findByMail(credentailsDto.mail())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentailsDto.mail()),
                user.getPassword())){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setMail(user.getMail());
            userDto.setPassword(user.getPassword());
            return userDto;
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }
}
