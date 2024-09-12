package com.personal.district.event.service;

import com.personal.district.event.model.Event;
import com.personal.district.event.repository.EventDbModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventDbModelRepository eventDbModelRepository;

    public boolean addEvent(Event eventDetails) {
        List<Event> events = eventDbModelRepository.findAll();
        if (eventDetails == null) {
            return false;
        }
        if(events.stream().filter(e -> e.getId().equals(eventDetails.getId())).count() != 0){
            return false;
        }
        eventDbModelRepository.save(eventDetails);
        return true;
    }

    public Event getEvent(String id) {
        return eventDbModelRepository.findById(id).orElse(null);
    }

    public List<Event> getEvents() {
        return eventDbModelRepository.findAll();
    }
}
