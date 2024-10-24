package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.JwtTokenInfo;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import com.server.healthapp.springHealthApp.entity.UserEntity;
import org.springframework.stereotype.Service;

public interface LoginService {
    public UserEntity userLogin(LoginDto Login);
    public void saveRefreshToken(String userId, JwtTokenInfo jwtTokenInfo);
}
