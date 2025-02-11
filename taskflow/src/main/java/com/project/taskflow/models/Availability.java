package com.project.taskflow.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    private LocalDate date;
    private boolean isAvailable;

    // Constructors
    public Availability() {}

    public Availability(Vendor vendor, LocalDate date, boolean isAvailable) {
        this.vendor = vendor;
        this.date = date;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    // toString
    @Override
    public String toString() {
        return "Availability{id=" + id + ", vendor=" + vendor + ", date=" + date + ", isAvailable=" + isAvailable + "}";
    }
}
