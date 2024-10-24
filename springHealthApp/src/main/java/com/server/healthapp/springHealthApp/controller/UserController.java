package com.server.healthapp.springHealthApp.controller;


import com.server.healthapp.springHealthApp.Service.UserRegisterService;
import com.server.healthapp.springHealthApp.dto.UserDto;
import com.server.healthapp.springHealthApp.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Controller
@Tag(name = "User", description = "회원정보 수정")
public class UserController {

    private final UserRegisterService userRegisterService;

    public UserController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    // 회원가입을 담당하는 함수. registerUser
    @PostMapping("/users/")
    @Operation(summary = "회원가입 요청", description = "반환 코드 -> 성공 :201 / 요청이 잘못 됨 : 400  /  서버 오류 : 500")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        log.info(user.toString());
        try {
            userRegisterService.registerUser(user);
            return new ResponseEntity<>("User register succesfully", HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버의 응답을 받을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//registerUser

    //회원가입시 아이디를 중복체크하는 함수.
    @GetMapping("/Get/")
    @Operation(summary = "아이디 중복 체크", description = "")
    public ResponseEntity<String> checkUserId(@RequestParam("id") String id) {
        try {
            userRegisterService.checkUserId(id);
            return new ResponseEntity<>("사용 가능한 아이디.", HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버에서 응답을 받을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //


    }//end CheckId


}//userController
