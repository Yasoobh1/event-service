package com.eventService.eventService.controller;


import com.eventService.eventService.dto.AddTicketTypeRequest;
import com.eventService.eventService.service.TicketService;
import com.eventService.eventService.model.TicketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add-ticket-type")
    public ResponseEntity<TicketEntity> addTicketType(@RequestBody AddTicketTypeRequest ticketTypeRequest) {
        try {
            TicketEntity newTicket = ticketService.addTicketType(ticketTypeRequest);
            return ResponseEntity.ok(newTicket);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
