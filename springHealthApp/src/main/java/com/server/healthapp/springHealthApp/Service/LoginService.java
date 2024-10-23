package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.Entity.SportEntity;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import com.server.healthapp.springHealthApp.dto.SportDto;
import com.server.healthapp.springHealthApp.mapper.SampleMapper;
import com.server.healthapp.springHealthApp.repository.SportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class LoginService {
    @Autowired
    private SampleMapper sampleMapper;
    @Autowired
    private SportRepository sportDtoRepository;
    @Autowired
    private SportRepository sportRepository;


    public boolean userLogin(LoginDto Login) {
        return true;
    }


    public SportDto getSportByID(int id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        HashMap<String, Object> res = sampleMapper.getSportById(paramMap);
        SportDto sportDto = new SportDto();
        sportDto.setId((int) res.get("id"));
        sportDto.setName((String) res.get("name"));
        sportDto.setMetric_01((String) res.get("metric_01"));
        sportDto.setMetric_02((String) res.get("metric_02"));

        return sportDto;

//        SportEntity sportEntity = sportRepository.findById(id).get();
//        SportDto sportDto = new SportDto();
//        sportDto.setId(sportEntity.getId());
//        sportDto.setName(sportEntity.getName());
//        sportDto.setMetric_01(sportEntity.getMetric_01());
//        sportDto.setMetric_02(sportEntity.getMetric_02());
//
//        return sportDto;


    }


    public boolean sportRegister (SportDto sportDto) {

//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", sportDto.getName());
//        paramMap.put("metric_01", sportDto.getMetric_01());
//        paramMap.put("metric_02", sportDto.getMetric_02());
//        int result = sampleMapper.registerSport(paramMap);
//        log.info("***************8787878787878878787878 \nresult: {}", result);
//
//        return result >0;

        SportEntity sportEntity = new SportEntity();
        sportEntity.setId(sportDto.getId());
        sportEntity.setName(sportDto.getName());
        sportEntity.setMetric_01(sportDto.getMetric_01());
        sportEntity.setMetric_02(sportDto.getMetric_02());
        try{ sportRepository.save(sportEntity);}
        catch (Exception e){
            return false;
        }
        return true;
    }


}
