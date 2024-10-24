package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.JwtTokenInfo;
import com.server.healthapp.springHealthApp.Authority.TokenProvider;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import com.server.healthapp.springHealthApp.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;

    @Transactional
    @Override
    public JwtTokenInfo signIn(LoginDto loginDto) {
        log.info("**** try generate Token");
        return tokenProvider.generateToken(loginDto);
    }//end signIn
}//end Class