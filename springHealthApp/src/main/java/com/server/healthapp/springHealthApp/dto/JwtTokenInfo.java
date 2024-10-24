package com.server.healthapp.springHealthApp.dto;


import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
public class JwtTokenInfo {
    private String grantType; // JWT 권한 인증 타입.
    private String accessToken; //
    private String refreshToken;

}
