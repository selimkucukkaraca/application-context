package com.demo.applicationcontext.applicationContext.service;

import com.demo.applicationcontext.applicationContext.dto.UserDto;
import com.demo.applicationcontext.applicationContext.dto.converter.UserConverter;
import com.demo.applicationcontext.applicationContext.dto.request.CreateUserRequest;
import com.demo.applicationcontext.applicationContext.model.User;
import com.demo.applicationcontext.applicationContext.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserService(UserRepository userRepository,
                       UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserDto save(CreateUserRequest request){
        User user = userConverter.toEntity(request);
        userRepository.save(user);
        return userConverter.convertUserToUserDto(user);
    }

    public List<UserDto> getAll(){
        return userRepository.findAll()
                .stream()
                .map(user ->
                        new UserDto(
                                user.getUsername(),
                                user.getMail(),
                                user.getPassword())).
                collect(Collectors.toList());
    }

    public void deleteByMail(String mail){
        User user = getUserByMail(mail);
        userRepository.delete(user);
    }

    private User getUserByMail(String mail){
        return userRepository.findUserByMail(mail);
    }


}
