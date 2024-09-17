package com.personal.district.booking.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.district.booking.config.RabbitMQConfig;
import com.personal.district.booking.model.Booking;
import com.personal.district.booking.model.BookingNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.management.Notification;

@Service
public class BookingEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    RabbitMQConfig rabbitMQConfig;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public void publishBookingCreated(Booking bookingId){
        BookingNotification event = createBookingCreatedEvent(bookingId);
        sendBookingNotification(event);
    }

    private void sendBookingNotification(BookingNotification event) {
        try {
            String message = objectMapper.writeValueAsString(event);
            rabbitTemplate.convertAndSend(rabbitMQConfig.getExchange(), rabbitMQConfig.getRoutingKey(), message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BookingNotification createBookingCreatedEvent(Booking booking) {
        return BookingNotification.builder()
                .bookingId(booking.getBookingId())
                .eventName(bookedEventName(String.valueOf(booking.getEventId())))
                .amount(booking.getAmount().toString())
                .timestamp(booking.getTimestamp().toString())
                .eTicketUrl(booking.getETicketUrl())
                .allocatedSeats(booking.getQuantity())
                .build();
    }

    private String bookedEventName(String eventId){
        String eventObject = restTemplate.getForObject("http://localhost:8083/v1/event/getEvent/" + eventId, String.class);
        JsonNode jsonNode = null;
        try {
            jsonNode = new ObjectMapper().readTree(eventObject);
            return jsonNode.get("name").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
