package com.eventService.eventService.model;
import java.time.LocalDate;

public class BookingNotification {
    private String eventName;
    private LocalDate eventDate;
    private String eventLocation;
    private String userName;
    private String ticketType;
    private int numberOfTickets;
    private double paymentAmount;

    public String getUserName() {
        return userName;
    }

    // Getters and Setters
}
