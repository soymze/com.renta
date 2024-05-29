package com.renta.renta.controllers;


import com.renta.renta.utilities.results.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    public ResponseEntity<?> handleDataResult(DataResult<?> dataResult){
        if(dataResult.isSuccess()){
            return ResponseEntity.ok(dataResult);
        }return ResponseEntity.badRequest().body(dataResult);
    }
}
