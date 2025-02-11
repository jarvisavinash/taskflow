package com.project.taskflow.dtos;

import java.time.LocalDate;

public class BookingRequestDTO {
    private Long userId;
    private Long subCategoryId;
    private Long vendorId;
    private LocalDate bookingDate;

    // Constructors
    public BookingRequestDTO() {}

    public BookingRequestDTO(Long userId, Long subCategoryId, Long vendorId, LocalDate bookingDate) {
        this.userId = userId;
        this.subCategoryId = subCategoryId;
        this.vendorId = vendorId;
        this.bookingDate = bookingDate;
    }

    // Getters & Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getSubCategoryId() { return subCategoryId; }
    public void setSubCategoryId(Long subCategoryId) { this.subCategoryId = subCategoryId; }

    public Long getVendorId() { return vendorId; }
    public void setVendorId(Long vendorId) { this.vendorId = vendorId; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
}

