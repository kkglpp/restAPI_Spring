package com.server.healthapp.springHealthApp.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@Tag(name = "plan", description = "운동 계획 관련 요청")
@Api(value = "로그인 및 Token 발급")
public class PlanController {


}
