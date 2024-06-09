package com.java.controller;

import com.java.entity.Plan;
import com.java.props.AppProperties;
import com.java.service.PlanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/plan-api")
@RestController

@Slf4j
public class PlanRestController {


    @Autowired
    private PlanService planService;

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer, String>> planCategories() {
        Map<Integer, String> categories = planService.getPlanCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> viewPlans() {
        List<Plan> plans = planService.getAllPlans();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> createPlan(@RequestBody Plan plan) {
        Map<String, String> msg = appProperties.getMessages();
        String responseMessage = "";
        Boolean isSaved = planService.savePlan(plan);
        responseMessage = isSaved ? msg.get("planSaveSuccess") : "Plan Not Saved";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<Plan> editPlan(@PathVariable("planId") Integer planId) {
        Plan plan = planService.getPlanById(planId);
        return new ResponseEntity<>(plan, HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
        Boolean updateStatus = planService.updatePlan(plan);
        String msg = "";
        msg = updateStatus ? "Plan Updated" : "Plan Not Updated";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/plan/{planID}")
    public ResponseEntity<String> deletePlan(@PathVariable("planId") Integer planId) {
        Boolean deleteStatus = planService.deletePlanById(planId);
        String msg = "";
        msg = deleteStatus ? "Plan Deleted" : "Plan Not Deleted";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
        Boolean isStatusChanged = planService.switchPlanStatus(planId, status);
        String msg = "";
        msg = isStatusChanged ? "Status Changed" : "Status Not Changed";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
