package com.personal.district.event.controller;

import com.personal.district.event.model.Event;
import com.personal.district.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/event")
public class EventController {

    @Autowired
    private EventService eventService;
    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event eventDetails) {
        if (eventDetails == null) {
            return ResponseEntity.badRequest().build();
        }
        if (eventService.addEvent(eventDetails)) {
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getEvent/{eventId}")
    public Event getEvent(@PathVariable String eventId) {
        return eventService.getEvent(eventId);
    }

    @GetMapping("/getEvents")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/getEventCount")
    public int getEventCount() {
        return eventService.getEvents().size();
    }

}
