package com.systems.settlement;

import com.systems.payment.gateway.model.PaymentEvent;
import org.junit.jupiter.api.Test;

public class SettlementServiceTest {

    @Test
    public void testProcessSettlement(){
        SettlementService settlementService=new SettlementService();

        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setPaymentId("test-id");
        paymentEvent.setAmount(100.0);
        paymentEvent.setCurrency("USD");

        settlementService.processSettlement(paymentEvent);

    }
}
