package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.PlanDto;
import com.server.healthapp.springHealthApp.exception.CustomException;
import com.server.healthapp.springHealthApp.repository.PlanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }


    @Override
    public void insertPlan(PlanDto planDto) {
        try {
            planRepository.insertPlan(planDto);
        } catch (Exception e) {
            log.error("error while deleting plan",e);
            throw new CustomException("error while deleting plan \n " + e.toString());
        }
    }

    @Override
    public List<PlanDto> getAllPlanById(String userId, int lastPlanId, int amount) {
        try{
            return  planRepository.getAllPlanById(userId, lastPlanId, amount);
        } catch (Exception e) {
            log.error("error while deleting plan",e);
            throw new CustomException("error while collecting plan \n " + e.toString());
        }
    }

    @Override
    public Optional<PlanDto> getPlanById(int planId) {
        try{
            Optional<PlanDto> result =  planRepository.getPlanById(planId);
            return planRepository.getPlanById(planId);
        } catch (Exception e) {
            throw new CustomException("error while getPlan \n" + e.toString());
        }
    }//end getPlanById

    @Override
    public void deletePlan(int planId) {
        try{
            planRepository.deletePlan(planId);
        } catch (Exception e) {
            throw new CustomException("error while deletePlan \n" + e.toString());
        }

    }//end deletePlan
}
