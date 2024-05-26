package com.renta.renta.business.dtos.requests.message;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class MessageCreateRequest implements Serializable {

    @NotBlank(message = "Please enter a username.")
    @Size(min = 3, max = 30, message = "Please enter a username between 3 and 40 characters.")
    private String senderName;
    @NotBlank(message = "Please enter your mail.")
    @Email(message = "Please ensure your email is in a valid format.")
    private String senderMail;
    private String subject;
    @NotBlank(message = "Please enter your message.")
    private String message;
}
