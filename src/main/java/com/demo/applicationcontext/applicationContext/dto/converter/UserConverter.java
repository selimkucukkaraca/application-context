package com.demo.applicationcontext.applicationContext.dto.converter;

import com.demo.applicationcontext.applicationContext.dto.UserDto;
import com.demo.applicationcontext.applicationContext.dto.request.CreateUserRequest;
import com.demo.applicationcontext.applicationContext.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto convertUserToUserDto (User user){
        return new UserDto(
                user.getUsername(),
                user.getMail(),
                user.getPassword()
        );
    }
    public User toEntity(CreateUserRequest request){
        return new User(request.getUserName(),
                request.getMail(),
                request.getPassword());
    }
}
