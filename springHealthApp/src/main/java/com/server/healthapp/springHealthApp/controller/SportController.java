package com.server.healthapp.springHealthApp.controller;

import com.server.healthapp.springHealthApp.Service.SportListService;
import com.server.healthapp.springHealthApp.dto.SportDto;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(value = "운동 종목 조회 관련")
public class SportController {

    private final SportListService sportListService;

    @Autowired
    public SportController(SportListService sportListService) {
        this.sportListService = sportListService;
    }

    @GetMapping("/sport")
    public SportDto getSportInfo(@RequestParam("id") int id) {
        SportDto res = sportListService.getSportByID(id);
        log.info(res.toString());
        return res;
    }


} // end class
