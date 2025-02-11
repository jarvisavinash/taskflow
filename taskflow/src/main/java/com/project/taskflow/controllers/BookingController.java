package com.project.taskflow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.taskflow.dtos.BookingRequestDTO;
import com.project.taskflow.models.Booking;
import com.project.taskflow.models.BookingStatus;
import com.project.taskflow.models.SubCategory;
import com.project.taskflow.models.User;
import com.project.taskflow.models.Vendor;
import com.project.taskflow.repositories.AvailabilityRepository;
import com.project.taskflow.repositories.BookingRepository;
import com.project.taskflow.repositories.SubCategoryRepository;
import com.project.taskflow.repositories.UserRepository;
import com.project.taskflow.repositories.VendorRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final VendorRepository vendorRepository;
    private final AvailabilityRepository availabilityRepository;

    public BookingController(BookingRepository bookingRepository, UserRepository userRepository,
                             SubCategoryRepository subCategoryRepository, VendorRepository vendorRepository,
                             AvailabilityRepository availabilityRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.vendorRepository = vendorRepository;
        this.availabilityRepository = availabilityRepository;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequestDTO request) {
        Optional<User> user = userRepository.findById(request.getUserId());
        Optional<SubCategory> subCategory = subCategoryRepository.findById(request.getSubCategoryId());
        Optional<Vendor> vendor = vendorRepository.findById(request.getVendorId());

        if (user.isPresent() && subCategory.isPresent() && vendor.isPresent()) {
            Booking booking = new Booking(user.get(), subCategory.get(), vendor.get(), request.getBookingDate(), BookingStatus.PENDING);
            return ResponseEntity.ok(bookingRepository.save(booking));
        }
        return ResponseEntity.badRequest().build();
    }
}

