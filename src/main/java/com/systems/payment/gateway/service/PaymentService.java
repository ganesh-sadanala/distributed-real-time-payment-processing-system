package com.example.payment.gateway.service;

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

    public void processPayment(PaymentRequest paymentRequest) {
        // Business logic to process payment...

        // Publish payment event to Kafka topic
        PaymentEvent paymentEvent = new PaymentEvent(paymentRequest.getPaymentId(), paymentRequest.getAmount(), paymentRequest.getCustomerId());
        kafkaTemplate.send("payment-events", paymentEvent);
    }
}

