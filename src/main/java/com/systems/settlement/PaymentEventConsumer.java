package com.systems.settlement;

import com.systems.payment.gateway.model.PaymentEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventConsumer {
    private final SettlementService settlementService;

    public PaymentEventConsumer(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @KafkaListener(topics = "payment-events", groupId = "settlement-group")
    public void consumePaymentEvent(ConsumerRecord<String, PaymentEvent> record) {
        PaymentEvent paymentEvent = record.value();
        settlementService.processSettlement(paymentEvent);
    }
}
