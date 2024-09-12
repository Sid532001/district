package com.personal.district.notification.service;

import org.springframework.stereotype.Service;

@Service
public class BookingEventListener {

    public void consume(String eventMessage){
        System.out.println("Received Booking: "+eventMessage);
//        processNotification(eventMessage);
    }

//    private void processNotification(String eventMessage) {
//        String userId = eventMessage.split(",")[0];
//    }
}
