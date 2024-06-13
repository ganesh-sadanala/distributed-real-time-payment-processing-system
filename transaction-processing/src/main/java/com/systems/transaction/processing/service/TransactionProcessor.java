package com.systems.transaction.processing.service;

import com.systems.common.model.PaymentEvent;
import com.systems.transaction.processing.model.ProcessedTransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProcessor {

    private final KafkaTemplate<String, ProcessedTransactionEvent> kafkaTemplate;

    @Autowired
    public TransactionProcessor(KafkaTemplate<String, ProcessedTransactionEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void processTransaction(PaymentEvent paymentEvent) {
        // Business logic to process transaction...
        System.out.println("Processing transaction for payment ID: " + paymentEvent.getPaymentId());

        // Create a processed transaction event
        ProcessedTransactionEvent processedTransactionEvent = new ProcessedTransactionEvent(paymentEvent.getPaymentId(), paymentEvent.getAmount(), paymentEvent.getCurrency());

        // publish the processed transaction event to kafka
        kafkaTemplate.send("processed-transaction-events", processedTransactionEvent);
    }
}
