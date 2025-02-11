package com.project.taskflow.models;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String location;

    @ManyToMany
    @JoinTable(
        name = "vendor_services",
        joinColumns = @JoinColumn(name = "vendor_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> servicesOffered;

    // Constructors
    public Vendor() {}

    public Vendor(User user, String location, Set<Service> servicesOffered) {
        this.user = user;
        this.location = location;
        this.servicesOffered = servicesOffered;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Set<Service> getServicesOffered() { return servicesOffered; }
    public void setServicesOffered(Set<Service> servicesOffered) { this.servicesOffered = servicesOffered; }

    // toString
    @Override
    public String toString() {
        return "Vendor{id=" + id + ", user=" + user + ", location='" + location + "', servicesOffered=" + servicesOffered + "}";
    }
}


