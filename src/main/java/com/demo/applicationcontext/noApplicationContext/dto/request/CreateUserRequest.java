package com.demo.applicationcontext.noApplicationContext.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String userName;
    private String mail;
    private String password;
}
