package com.server.healthapp.springHealthApp.mapper;

import com.server.healthapp.springHealthApp.dto.PlanDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserSportPlanMapper {
    HashMap<String, Object> addPlan(PlanDto params);
    List<PlanDto> getPlanListByUserId(String userId, int lastPlanId, int amount);
    void deletePlan(int planId);
    PlanDto getPlanById(int planId);
}//end interface
