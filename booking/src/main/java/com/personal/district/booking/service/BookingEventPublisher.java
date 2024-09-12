package com.personal.district.booking.service;

import com.personal.district.booking.model.Booking;
import com.personal.district.booking.model.BookingNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingEventPublisher {
    @Autowired
    BookingService bookingService;

    public void publishBookingCreated(Booking bookingId){
        String event = createBookingCreatedEvent(bookingId);
    }

    private String createBookingCreatedEvent(Booking booking) {
        BookingNotification bookingNotification = BookingNotification.builder()
                .bookingId(booking.getBookingId())
                .eventName(bookingService.eventName(String.valueOf(booking.getEventId())))
                .amount(booking.getAmount().toString())
                .timestamp(booking.getTimestamp().toString())
                .eTicketUrl(booking.getETicketUrl())
                .allocatedSeats(booking.getQuantity())
                .build();
        return bookingNotification.toString();
    }
}
