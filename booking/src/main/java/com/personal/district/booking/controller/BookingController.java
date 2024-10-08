package com.personal.district.booking.controller;

import com.personal.district.booking.model.Booking;
import com.personal.district.booking.service.BookingEventPublisher;
import com.personal.district.booking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    final static Logger logger = LoggerFactory.getLogger(BookingController.class.getName());

    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingEventPublisher bookingEventPublisher;

    @PostMapping("/newBooking")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingByID(@PathVariable String bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/getBookingCount")
    public int getBookingCount() {
        return bookingService.getAllBookings().size();
    }

    @PutMapping
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/something")
    public ResponseEntity<String> createLogs() {
        logger.warn("This is a warning message");
        return ResponseEntity.ok().body("All Ok");
    }
}