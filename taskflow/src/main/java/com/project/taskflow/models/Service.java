package com.project.taskflow.models;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;

    // Constructors
    public Service() {}

    public Service(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // toString
    @Override
    public String toString() {
        return "Service{id=" + id + ", name='" + name + "', description='" + description + "'}";
    }
}

