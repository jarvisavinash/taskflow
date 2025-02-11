package com.project.taskflow.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING) // Ensures ENUM is stored as STRING in DB
    private BookingStatus status;

    // Constructors
    public Booking() {}

    public Booking(User user, SubCategory subCategory, Vendor vendor, LocalDate bookingDate, BookingStatus status) {
        this.user = user;
        this.subCategory = subCategory;
        this.vendor = vendor;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public SubCategory getSubCategory() { return subCategory; }
    public void setSubCategory(SubCategory subCategory) { this.subCategory = subCategory; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user=" + user +
                ", subCategory=" + subCategory +
                ", vendor=" + vendor +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                '}';
    }
}

