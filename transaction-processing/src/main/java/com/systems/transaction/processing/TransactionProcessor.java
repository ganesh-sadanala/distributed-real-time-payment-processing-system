package com.systems.transaction.processing;

import com.systems.common.model.PaymentEvent;
import org.springframework.stereotype.Service;

@Service
public class TransactionProcessor {

    public void processTransaction(PaymentEvent paymentEvent) {
        // Business logic to process transaction...
        System.out.println("Processing transaction for payment ID: " + paymentEvent.getPaymentId());
    }
}
