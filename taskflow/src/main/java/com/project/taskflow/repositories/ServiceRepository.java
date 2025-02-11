package com.project.taskflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taskflow.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
