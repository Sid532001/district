package com.personal.district.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingEventListener {

    @Autowired
    ObjectMapper objectMapper;

    public void consume(String eventMessage) throws JsonMappingException {
        System.out.println("Received Booking: "+eventMessage);
        processNotification(eventMessage);
    }

    private JsonNode processNotification(String eventMessage) throws JsonMappingException {
        try{
            return objectMapper.readTree(eventMessage);
        }catch (JsonProcessingException e) {
            throw new JsonMappingException("Error while processing the event message");
        }
    }
}
