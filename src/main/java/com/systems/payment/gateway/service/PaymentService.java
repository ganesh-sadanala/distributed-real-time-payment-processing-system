package com.systems.payment.gateway.service;

import com.systems.payment.gateway.model.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    @Autowired
    public PaymentService(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void processPayment(PaymentEvent paymentEvent) {
        // Business logic to process payment
        System.out.println("Processing payment: " + paymentEvent.getPaymentId());

        // Send payment event to Kafka
        kafkaTemplate.send("payment-events", paymentEvent);
    }
}

