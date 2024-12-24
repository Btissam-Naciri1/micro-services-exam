package com.example.Commandes_service.service;

import com.example.Commandes_service.model.Order;
import com.example.Commandes_service.repo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private CommandeRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    public Order saveOrder(Order order) {
        // Save the order to the database
        Order savedOrder = repository.save(order);

        // Publish the order event to Kafka
        kafkaTemplate.send(TOPIC, "Order created: " + savedOrder.getId());

        return savedOrder;
    }
}

