package com.eventService.eventService.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TicketBookingResponse {
    private String message;
    private Long bookingId;
    private double totalPrice;

    // Constructor, Getters, and Setters
}
