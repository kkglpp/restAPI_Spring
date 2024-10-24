package com.server.healthapp.springHealthApp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(hidden = true)
    String register_date;
    @Schema(hidden = true)
    String refresh_token;

}
