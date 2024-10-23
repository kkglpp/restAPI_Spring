package com.server.healthapp.springHealthApp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    String id;
    String password_hash;
    String name;
    String email;
    String phone;
    String register_date;
    String refresh_token;

}
