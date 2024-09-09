package com.personal.district.event.repository;

import com.personal.district.event.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventDbModelRepository extends MongoRepository<Event, String> {
}