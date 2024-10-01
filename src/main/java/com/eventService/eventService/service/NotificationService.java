package com.eventService.eventService.service;

import com.eventService.eventService.model.BookingNotification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendBookingNotification(BookingNotification notification) {
        // Logic to send email/sms notification
        System.out.println("Booking notification sent to user: " + notification.getUserName());
    }

    public void sendCancellationNotification(BookingNotification notification) {
        // Logic to send cancellation notification
        System.out.println("Cancellation notification sent to user: " + notification.getUserName());
    }
}
