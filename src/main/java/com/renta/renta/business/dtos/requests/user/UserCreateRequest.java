package com.renta.renta.business.dtos.requests.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class UserCreateRequest implements Serializable {

    @NotBlank(message = "Please enter a username.")
    @Size(min = 3, max = 30, message = "Please enter a username between 3 and 40 characters.")
    private String userName;
    @NotBlank(message = "Please enter your password.")
    @Size(min = 8, max = 20, message = "Password length should be in the range of 8 to 20 characters.")
    private String password;
    @NotBlank(message = "Please enter your mail.")
    @Email(message = "Please ensure your email is in a valid format.")
    private String mail;
}