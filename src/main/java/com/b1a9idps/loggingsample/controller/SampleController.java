package com.b1a9idps.loggingsample.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.loggingsample.exception.NotFoundException;
import com.b1a9idps.loggingsample.request.UserCreateRequest;
import com.b1a9idps.loggingsample.response.ErrorResponse;
import com.b1a9idps.loggingsample.response.UserResponse;

@RestController
@RequestMapping("/users")
public class SampleController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping
    public List<UserResponse> getUsers() {
        return buildUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable int id) {
        List<UserResponse> users = buildUsers();
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest request) {
        logger.info("request is {}", request.toString());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.of(Optional.of(new ErrorResponse("NotFound")));
    }

    private List<UserResponse> buildUsers() {
        return List.of(
                UserResponse.newInstance(1, "name1"),
                UserResponse.newInstance(2, "name2"));
    }
}
