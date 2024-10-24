package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.SportDto;
import com.server.healthapp.springHealthApp.entity.SportEntity;
import com.server.healthapp.springHealthApp.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SportListService {

    private final SportRepository sportRepository;

    @Autowired
    public SportListService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public boolean sportRegister(SportDto sportDto) {
        SportEntity sportEntity = new SportEntity();
        sportEntity.setId(sportDto.getId());
        sportEntity.setName(sportDto.getName());
        sportEntity.setMetric_01(sportDto.getMetric_01());
        sportEntity.setMetric_02(sportDto.getMetric_02());
        try {
            sportRepository.save(sportEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    } // end sportRegister

    public SportDto getSportByID(int id) {
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("id", id);
//        HashMap<String, Object> res = sampleMapper.getSportById(paramMap);
//        SportDto sportDto = new SportDto();
//        sportDto.setId((int) res.get("id"));
//        sportDto.setName((String) res.get("name"));
//        sportDto.setMetric_01((String) res.get("metric_01"));
//        sportDto.setMetric_02((String) res.get("metric_02"));
//
//        return sportDto;

        SportEntity sportEntity = sportRepository.findById(id).get();
        SportDto sportDto = new SportDto();
        sportDto.setId(sportEntity.getId());
        sportDto.setName(sportEntity.getName());
        sportDto.setMetric_01(sportEntity.getMetric_01());
        sportDto.setMetric_02(sportEntity.getMetric_02());

        return sportDto;


    }

}
