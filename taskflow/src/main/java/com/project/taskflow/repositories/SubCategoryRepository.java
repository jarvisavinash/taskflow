package com.project.taskflow.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taskflow.models.SubCategory;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByServiceId(Long serviceId);
}
