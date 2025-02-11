package com.project.taskflow.controllers;

import org.springframework.web.bind.annotation.*;

import com.project.taskflow.models.Service;
import com.project.taskflow.repositories.ServiceRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    // New method to fetch service by ID
    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable Long id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
}


