package com.eventService.eventService.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TicketBookingRequest {
    private Long eventId;
    private Long userId;
    private String ticketType;
    private int numberOfTickets;
}
