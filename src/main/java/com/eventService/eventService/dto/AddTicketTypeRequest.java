package com.eventService.eventService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AddTicketTypeRequest {
    private Long eventId;
    private String ticketType;
    private double price;
    private int quantity;

}
