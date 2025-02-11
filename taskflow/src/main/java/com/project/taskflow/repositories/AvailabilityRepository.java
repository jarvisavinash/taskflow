package com.project.taskflow.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taskflow.models.Availability;
import com.project.taskflow.models.Vendor;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByVendorAndDateAndIsAvailableTrue(Vendor vendor, LocalDate date);
}
