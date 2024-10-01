package com.eventService.eventService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class PaymentRequest {

    // Getters and Setters
    private String userName;
    private String eventName;
    private String eventLocation;
    private String ticketType;
    private int numberOfTickets;
    private double paymentAmount;
    private PaymentMethod paymentMethod;

    // Constructors
    public PaymentRequest() {}

    public PaymentRequest(String userName, String eventName, String eventLocation, String ticketType,
                          int numberOfTickets, double paymentAmount, PaymentMethod paymentMethod) {
        this.userName = userName;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.ticketType = ticketType;
        this.numberOfTickets = numberOfTickets;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "userName='" + userName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                ", paymentAmount=" + paymentAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
    public class PaymentMethod {
        private String cardNumber;
        private String expiryDate;
        private String cvv;
    }

}
