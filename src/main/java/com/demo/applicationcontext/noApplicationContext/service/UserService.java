package com.demo.applicationcontext.noApplicationContext.service;

import com.demo.applicationcontext.noApplicationContext.dto.UserDto;
import com.demo.applicationcontext.noApplicationContext.dto.request.CreateUserRequest;
import com.demo.applicationcontext.noApplicationContext.model.User;
import com.demo.applicationcontext.noApplicationContext.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(CreateUserRequest request){
        User user = new User(
                request.getUserName(),
                request.getMail(),
                request.getPassword()
        );

        userRepository.save(user);

        return new UserDto(user.getUserName(), user.getMail(), user.getPassword());
    }

    public List<UserDto> getAll(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getUserName(), user.getMail(), user.getPassword()))
                .collect(Collectors.toList());
    }

    public void delete(String mail){
        User user = getByMail(mail);
        userRepository.delete(user);
    }

    private User getByMail(String mail){
        return userRepository.findByMail(mail).get();

    }



}
