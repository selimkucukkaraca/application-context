package com.demo.applicationcontext.noApplicationContext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String userName;
    private String mail;
    private String password;
}
