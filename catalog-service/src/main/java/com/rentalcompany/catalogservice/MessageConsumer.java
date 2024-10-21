package com.rentalcompany.catalogservice;

import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}


