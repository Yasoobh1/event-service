package com.eventService.eventService.controller;

import com.eventService.eventService.dto.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @PostMapping("/payment")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        // Simulate payment processing logic
        return ResponseEntity.ok("Payment processed successfully for amount: " + paymentRequest.getPaymentAmount());
    }
}
