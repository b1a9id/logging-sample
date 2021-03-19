package com.b1a9idps.loggingsample.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.loggingsample.exception.NotFoundException;
import com.b1a9idps.loggingsample.response.ErrorResponse;

@RestController
@RequestMapping("/samples")
public class SampleController {

    @GetMapping("/ok")
    public Map<String, String> index() {
        return Map.of();
    }

    @GetMapping("/notfound")
    public Map<String, String> indexThrowException() {
        if (true) {
            throw new NotFoundException();
        }
        return Map.of();
    }

    @PostMapping("/put")
    public Map<String, String> indexPut(@RequestBody Map<String, String> request) {
        return Map.of();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.of(Optional.of(new ErrorResponse("NotFound")));
    }
}
