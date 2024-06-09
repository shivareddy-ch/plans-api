package com.java.service;

import com.java.entity.Plan;
import com.java.entity.PlanCategory;
import com.java.repository.PlanCategoryRepository;
import com.java.repository.PlanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService{

    Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanCategoryRepository planCategoryRepository;
    @Override
    public Map<Integer, String> getPlanCategories() {
        List<PlanCategory> planCategories = planCategoryRepository.findAll();
        Map<Integer,String> categoryMap = new HashMap<>();
        planCategories.forEach(category->{
            categoryMap.put(category.getCategoryId(),category.getCategoryName());
        });
        return categoryMap;
    }

    @Override
    public boolean savePlan(Plan plan) {
        Plan saved = planRepository.save(plan);
        //return saved.getPlanId()!=null ? true: false; //1 year
        return saved.getPlanId()!=null;
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        Optional<Plan> plan= planRepository.findById(planId);

        return plan.isPresent()?plan.get():null;
    }

    @Override
    public boolean updatePlan(Plan plan) {
        Plan save = planRepository.save(plan);
        return save.getPlanId()!=null;
    }

    @Override
    public boolean deletePlanById(Integer planId) {
        Boolean deleted =  false;
        try{
            planRepository.deleteById(planId);
            deleted = true;
        }
        catch (Exception e){
        }
        return deleted;
    }

    @Override
    public boolean switchPlanStatus(Integer planId, String activeSw) {
        Optional<Plan> optionalPlan = planRepository.findById(planId);
        if(optionalPlan.isPresent()){
            Plan plan = optionalPlan.get();
            plan.setActiveSw(activeSw);
            planRepository.save(plan);
            return true;
        }
        return false;
    }
}
