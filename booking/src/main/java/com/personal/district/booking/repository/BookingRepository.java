package com.personal.district.booking.repository;

import com.personal.district.booking.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking,String>{
}
