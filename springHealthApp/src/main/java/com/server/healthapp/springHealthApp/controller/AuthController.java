package com.server.healthapp.springHealthApp.controller;

import com.server.healthapp.springHealthApp.dto.JwtTokenInfo;
import com.server.healthapp.springHealthApp.Service.LoginService;
import com.server.healthapp.springHealthApp.Service.LoginServiceImpl;
import com.server.healthapp.springHealthApp.Service.MemberService;
import com.server.healthapp.springHealthApp.Service.MemberServiceImpl;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import com.server.healthapp.springHealthApp.dto.SendTokenDto;
import com.server.healthapp.springHealthApp.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "Auth", description = "로그인 및 인증관련 요청")
@RestController
@Api(value = "로그인 및 Token 발급")
public class AuthController {
    //Field
    private final LoginService loginService;
    private final MemberService memberService;
    @Autowired
    public AuthController(LoginServiceImpl loginService, MemberServiceImpl memberService) {
        this.loginService = loginService;
        this.memberService = memberService;
    }
    @PostMapping("Auth/login")
    @Operation(summary = "로그인 요청. ", description = "성공하면 토큰 값 반환, 실패하면 401 에러")
    public ResponseEntity<SendTokenDto> userLogin(@RequestBody LoginDto user) {
        UserEntity loginResult = loginService.userLogin(user);// 유저 존재 여부확인
        JwtTokenInfo jwtTokenInfo = memberService.signIn(user);
        loginService.saveRefreshToken(loginResult.getId(), jwtTokenInfo);
        SendTokenDto sendTokenDto = new SendTokenDto();
        sendTokenDto.setAccessToken(jwtTokenInfo.getAccessToken());
        sendTokenDto.setRefreshToken(jwtTokenInfo.getRefreshToken());
        log.info(user.getUserId() + "try login result : success ");
        return ResponseEntity.ok(sendTokenDto);
    }


} // end Class
