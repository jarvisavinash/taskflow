package com.project.taskflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taskflow.models.Vendor;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findByLocation(String location);
}
