package com.demo.applicationcontext.applicationContext.controller;

import com.demo.applicationcontext.applicationContext.dto.UserDto;
import com.demo.applicationcontext.applicationContext.dto.request.CreateUserRequest;
import com.demo.applicationcontext.applicationContext.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spring")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
        userService.deleteByMail(mail);
        return ResponseEntity.noContent().build();
    }

}
