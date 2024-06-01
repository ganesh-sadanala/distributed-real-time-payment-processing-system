package com.systems.transaction.processing;

import com.systems.payment.gateway.model.PaymentEvent;
import org.junit.jupiter.api.Test;

public class TransactionProcessorTest {

    @Test
    public void testProcessTransaction(){
        TransactionProcessor transactionProcessor=new TransactionProcessor();

        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setPaymentId("test-id");
        paymentEvent.setAmount(100.0);
        paymentEvent.setCurrency("USD");

        transactionProcessor.processTransaction(paymentEvent);
    }
}