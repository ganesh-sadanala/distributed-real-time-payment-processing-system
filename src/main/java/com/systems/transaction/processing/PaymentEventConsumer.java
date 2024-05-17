package com.systems.transaction.processing;

import com.systems.payment.gateway.model.PaymentEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumer {

    private final TransactionProcessor transactionProcessor;

    public PaymentEventConsumer(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    @KafkaListener(topics = "payment-events", groupId = "transaction-processing-group")
    public void consumePaymentEvent(ConsumerRecord<String, PaymentEvent> record) {
        PaymentEvent paymentEvent = record.value();
        transactionProcessor.processTransaction(paymentEvent);
    }
}

