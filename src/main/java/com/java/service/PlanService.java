package com.java.service;

import com.java.entity.Plan;

import java.util.List;
import java.util.Map;

public interface PlanService {
    public Map<Integer,String> getPlanCategories();
    public boolean savePlan(Plan plan);
    public List<Plan> getAllPlans();
    public Plan getPlanById(Integer planId);
    public boolean updatePlan(Plan plan);
    public boolean deletePlanById(Integer planId);
    public boolean switchPlanStatus(Integer planId,String activeSw);
}
