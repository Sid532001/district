package com.personal.district.booking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "bookings")
@Getter
@Setter
@AllArgsConstructor
public class Booking {
    @Id
    private String bookingId;
    private long spaceId;
    private String userId;
    private Long amount;
    private LocalDateTime timestamp;
}