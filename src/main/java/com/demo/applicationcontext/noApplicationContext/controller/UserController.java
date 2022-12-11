package com.demo.applicationcontext.noApplicationContext.controller;

import com.demo.applicationcontext.noApplicationContext.dto.UserDto;
import com.demo.applicationcontext.noApplicationContext.dto.request.CreateUserRequest;
import com.demo.applicationcontext.noApplicationContext.model.User;
import com.demo.applicationcontext.noApplicationContext.repository.UserRepository;
import com.demo.applicationcontext.noApplicationContext.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository = new UserRepository();

    private UserService userService = new UserService(userRepository);


    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody CreateUserRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity
                .ok(userService.getAll());
    }

    @DeleteMapping("/{mail}")
    public ResponseEntity<Void> delete(@PathVariable String mail){
        userService.delete(mail);

        return ResponseEntity.noContent().build();
    }





}
