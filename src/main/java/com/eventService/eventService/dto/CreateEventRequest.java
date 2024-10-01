package com.eventService.eventService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class CreateEventRequest {
    private String name;
    private LocalDate eventDate;
    private String location;
    private int totalTickets;
    private int availableTickets;

}
