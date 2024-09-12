package com.personal.district.booking.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingNotification {
    private String bookingId;
    private String eventName;
    private String amount;
    private int allocatedSeats;
    private String timestamp;
    private String eTicketUrl;
}
