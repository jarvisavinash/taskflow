package com.project.taskflow.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_categories")
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public SubCategory() {}

    public SubCategory(String name, Service service) {
        this.name = name;
        this.service = service;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }
}


