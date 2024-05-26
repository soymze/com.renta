package com.renta.renta.controllers;

import com.renta.renta.business.abstracts.MessageService;
import com.renta.renta.business.dtos.requests.message.MessageCreateRequest;
import com.renta.renta.utilities.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    //@Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Result> createMessage(@Valid @RequestBody MessageCreateRequest messageCreateRequest) {

        Result result = messageService.createMessage(messageCreateRequest);

        return ResponseEntity.ok().body(result);
    }
}
