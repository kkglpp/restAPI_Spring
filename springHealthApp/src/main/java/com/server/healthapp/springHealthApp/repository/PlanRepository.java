package com.server.healthapp.springHealthApp.repository;

import com.server.healthapp.springHealthApp.dto.PlanDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PlanRepository {
    public void insertPlan(PlanDto planDto);

    public List<PlanDto> getAllPlanById(String userId, int lastPlanId, int amount);

    public Optional<PlanDto> getPlanById(int planId);

    public void deletePlan(int planId);

}
