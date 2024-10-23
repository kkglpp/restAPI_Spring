package com.server.healthapp.springHealthApp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SendTokenDto {
    private String accessToken;
    private String refreshToken;

}
