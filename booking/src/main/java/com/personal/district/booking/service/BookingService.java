package com.personal.district.booking.service;


import com.personal.district.booking.model.Booking;
import com.personal.district.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking);
    }
    public Booking getBookingById(String id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
    }
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.findById(booking.getBookingId())
                .map(existingBooking -> {
                    existingBooking.setSpaceId(booking.getSpaceId());
                    existingBooking.setUserId(booking.getUserId());
                    existingBooking.setAmount(booking.getAmount());
                    existingBooking.setTimestamp(booking.getTimestamp());
                    return bookingRepository.save(existingBooking);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + booking.getBookingId()));
    }
    public void deleteBooking(String bookingId){
        bookingRepository.deleteById(bookingId);
    }
}
