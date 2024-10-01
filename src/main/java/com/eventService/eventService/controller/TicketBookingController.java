package com.eventService.eventService.controller;

import com.eventService.eventService.dto.TicketBookingRequest;
import com.eventService.eventService.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping("/book-ticket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketBookingRequest ticketRequest) {
        try {
            String response = String.valueOf(ticketBookingService.bookTicket(ticketRequest));
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}