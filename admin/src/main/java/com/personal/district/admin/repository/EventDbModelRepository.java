package com.personal.district.admin.repository;

import com.personal.district.admin.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventDbModelRepository extends MongoRepository<Event, String> {
}