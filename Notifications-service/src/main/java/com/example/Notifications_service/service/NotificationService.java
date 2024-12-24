package com.example.Notifications_service.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consumeOrderMessage(String message) {
        System.out.println("Received order message: " + message);
        sendNotification(message);
    }

    private void sendNotification(String message) {
        // Simulate sending a notification (e.g., email, SMS, etc.)
        System.out.println("Sending notification for order: " + message);
    }
}
