package com.server.healthapp.springHealthApp.repository;

import com.server.healthapp.springHealthApp.dto.PlanDto;
import com.server.healthapp.springHealthApp.mapper.UserSportPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanRepositoryImpl implements PlanRepository {

    private final UserSportPlanMapper userSportPlanMapper;

    @Autowired
    public PlanRepositoryImpl(UserSportPlanMapper userSportPlanMapper) {
        this.userSportPlanMapper = userSportPlanMapper;
    }


    @Override
    public void insertPlan(PlanDto planDto) {
        userSportPlanMapper.addPlan(planDto);
    }

    @Override
    public List<PlanDto> getAllPlanById(String userId, int lastPlanId, int amount) {
        return userSportPlanMapper.getPlanListByUserId(userId, lastPlanId, amount);
    }

    @Override
    public Optional<PlanDto> getPlanById(int planId) {
        return Optional.ofNullable(userSportPlanMapper.getPlanById(planId));
    }

    @Override
    public void deletePlan(int planId) {
        userSportPlanMapper.deletePlan(planId);
    }

}
