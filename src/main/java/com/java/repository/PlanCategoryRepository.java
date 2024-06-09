package com.java.repository;

import com.java.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanCategoryRepository extends JpaRepository<PlanCategory,Integer> {
}
