package com.demo.applicationcontext.noApplicationContext.repository;

import com.demo.applicationcontext.noApplicationContext.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private final List<User> userList = new ArrayList<>();

    public User save(User user){
        userList.add(user);
        return user;
    }

    public List<User> findAll(){
        return userList;
    }

    public void delete(User user){
        userList.remove(user);
    }

    public Optional<User> findByMail(String mail){
        return userList.stream()
                .filter(user -> user.getMail().equals(mail)).findFirst();
    }
}
