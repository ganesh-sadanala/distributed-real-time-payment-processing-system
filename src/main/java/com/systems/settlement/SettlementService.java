package com.systems.settlement;

import com.systems.payment.gateway.model.PaymentEvent;
import org.springframework.stereotype.Service;

@Service
public class SettlementService {

    public void processSettlement(PaymentEvent paymentEvent) {
        // Business logic to handle settlement...
        System.out.println("Processing settlement for payment ID: " + paymentEvent.getPaymentId());
    }
}

