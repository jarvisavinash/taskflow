package com.project.taskflow.controllers;

import org.springframework.web.bind.annotation.*;

import com.project.taskflow.models.SubCategory;
import com.project.taskflow.repositories.SubCategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryController(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @GetMapping("/{serviceId}")
    public List<SubCategory> getSubCategoriesByService(@PathVariable Long serviceId) {
        return subCategoryRepository.findByServiceId(serviceId);
    }
    
    @PostMapping
    public SubCategory createSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

}
