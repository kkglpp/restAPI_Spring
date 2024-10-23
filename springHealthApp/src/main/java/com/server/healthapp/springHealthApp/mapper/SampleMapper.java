package com.server.healthapp.springHealthApp.mapper;

//import org.mapstruct.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.HashMap;

@Mapper
public interface SampleMapper {
    HashMap<String, Object> getSportById(HashMap<String, Object> paramMap);
    int registerSport(HashMap<String, Object> paramMap);
}
