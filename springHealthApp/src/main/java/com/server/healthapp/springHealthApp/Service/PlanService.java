package com.server.healthapp.springHealthApp.Service;


import com.server.healthapp.springHealthApp.dto.PlanDto;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    public void insertPlan(PlanDto planDto);

    public List<PlanDto> getAllPlanById(String userId, int lastPlanId, int amount);

    public Optional<PlanDto> getPlanById(int planId);

    public void deletePlan(int planId);

}
