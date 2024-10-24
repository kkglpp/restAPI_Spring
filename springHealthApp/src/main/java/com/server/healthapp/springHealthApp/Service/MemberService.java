package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.JwtTokenInfo;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    public JwtTokenInfo signIn(LoginDto loginDto);
}
