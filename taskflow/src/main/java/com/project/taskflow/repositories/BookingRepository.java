package com.project.taskflow.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.taskflow.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
