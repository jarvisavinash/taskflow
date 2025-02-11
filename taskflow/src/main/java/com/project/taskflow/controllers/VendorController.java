package com.project.taskflow.controllers;

import org.springframework.web.bind.annotation.*;
import com.project.taskflow.models.Vendor;
import com.project.taskflow.repositories.VendorRepository;
import java.util.List;


@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @GetMapping("/location/{location}")
    public List<Vendor> getVendorsByLocation(@PathVariable String location) {
        return vendorRepository.findByLocation(location);
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return vendorRepository.findById(id).orElse(null);
    }
}

