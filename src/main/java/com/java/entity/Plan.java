package com.java.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class Plan {


    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_ID")
    private Integer planId;

    @Column(name = "PLAN_NAME")
    private String planName;

    @Column(name = "PLAN_START_DATE")
    private LocalDate planStartDate;

    @Column(name = "PLAN_END_DATE")
    private LocalDate planEndDate;

    @Column(name = "ACTIVE_SW")
    private String activeSw;

    @Column(name = "PLAN_CATEGORY_ID")
    private Integer planCategoryId;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "UPDATED_DATE",insertable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;
}
