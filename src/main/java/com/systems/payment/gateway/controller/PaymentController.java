package com.systems.payment.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final com.example.payment.gateway.service.PaymentService paymentService;

    @Autowired
    public PaymentController(com.example.payment.gateway.service.PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payments")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok("Payment processed successfully");
    }
}

