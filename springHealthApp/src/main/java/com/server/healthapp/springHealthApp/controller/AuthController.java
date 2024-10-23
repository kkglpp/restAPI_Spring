package com.server.healthapp.springHealthApp.controller;

import com.server.healthapp.springHealthApp.Service.LoginService;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import com.server.healthapp.springHealthApp.dto.ResponseDto;
import com.server.healthapp.springHealthApp.dto.SendTokenDto;
import com.server.healthapp.springHealthApp.dto.SportDto;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name="Auth", description = "로그인 및 인증관련")
@RestController
@Api(value = "로그인 및 Token 발급")
public class AuthController {
    //Field
    @Autowired
    private LoginService loginService;
    //Method
    @GetMapping("/get")
    public String getUsersHealthGoalList(@RequestParam("userId") String userID) {
        log.info(userID + " get his GoalList ");
        return "{}";
    }
    @PostMapping("/login")
    @Operation(summary = "로그인 요청. ", description = "성공하면 토큰 값 반환, 실패하면 401 에러")
    public ResponseEntity<SendTokenDto> userLogin(@RequestBody LoginDto user) {
        boolean loginResult = loginService.userLogin(user);
        //로그인에 성공할 경우
        if (loginResult) {
            SendTokenDto sendTokenDto = new SendTokenDto();
            sendTokenDto.setAccessToken("accessToken is here");
            sendTokenDto.setRefreshToken("refreshToken is here");
            log.info(user.getUserId() + "try login and " + true);
            return ResponseEntity.ok(sendTokenDto);
        }
        //로그인에 실패할 경우
        log.warn(user.getUserId() + "fail to login");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/getsport")
    public SportDto getSportInfo(@RequestParam ("id") int id){
        SportDto res =  loginService.getSportByID( id );
        log.info(res.toString());
        return res;
    }

    @PostMapping("/insertSport")
    public ResponseDto insertSport(@RequestBody SportDto sport) {
        SportDto sportDto = new SportDto();
        ResponseDto responseDto = new ResponseDto();

        boolean rs = loginService.sportRegister(sport);
        if(rs) {
            responseDto.setMessage("ok");
        }else{
            responseDto.setMessage("fail");
        }
        return responseDto;
    }


} // end Class
