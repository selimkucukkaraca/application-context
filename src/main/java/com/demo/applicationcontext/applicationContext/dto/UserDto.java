package com.demo.applicationcontext.applicationContext.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String username;
    private String mail;
    private String password;
}
