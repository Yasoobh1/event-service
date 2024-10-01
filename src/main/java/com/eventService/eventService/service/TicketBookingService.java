package com.eventService.eventService.service;

import com.eventService.eventService.dto.TicketBookingResponse;
import com.eventService.eventService.repository.BookingRepository;
import com.eventService.eventService.repository.EventRepository;
import com.eventService.eventService.repository.TicketRepository;
import com.eventService.eventService.model.*;
import com.eventService.eventService.dto.TicketBookingRequest;
import com.eventService.eventService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public TicketBookingResponse bookTicket(TicketBookingRequest ticketRequest) {
        // Check if user exists
        Optional<UserEntity> userOpt = userRepository.findById(ticketRequest.getUserId());
        if (!userOpt.isPresent()) {
            throw new RuntimeException("User not found");
        }

        // Check if event exists
        Optional<Event> eventOpt = eventRepository.findById(ticketRequest.getEventId());
        if (!eventOpt.isPresent()) {
            throw new RuntimeException("Event not found");
        }

        // Check if the ticket type exists and has enough availability
        Optional<TicketEntity> ticketOpt = ticketRepository.findByEventIdAndTicketType(ticketRequest.getEventId(), ticketRequest.getTicketType());
        if (!ticketOpt.isPresent()) {
            throw new RuntimeException("Ticket type not available");
        }

        TicketEntity ticket = ticketOpt.get();
        if (ticket.getQuantity() < ticketRequest.getNumberOfTickets()) {
            throw new RuntimeException("Not enough tickets available");
        }

        // Calculate total price
        double totalPrice = ticket.getPrice() * ticketRequest.getNumberOfTickets();

        // Simulate payment processing
        processPayment(totalPrice);

        // Save booking details
        BookingEntity booking = new BookingEntity();
        booking.setUserId(ticketRequest.getUserId());
        booking.setEventId(ticketRequest.getEventId());
        booking.setTicketType(ticketRequest.getTicketType());
        booking.setNumberOfTickets(ticketRequest.getNumberOfTickets());
        booking.setTotalPrice(totalPrice);
        booking.setCancelled(false);

        BookingEntity savedBooking = bookingRepository.save(booking);

        // Update ticket availability
        ticket.setQuantity(ticket.getQuantity() - ticketRequest.getNumberOfTickets());
        ticketRepository.save(ticket);

        // Return booking response
        TicketBookingResponse response = new TicketBookingResponse();
        response.setMessage("Booking successful");
        response.setBookingId(savedBooking.getId());
        response.setTotalPrice(totalPrice);

        return response;
    }

    private void processPayment(double amount) {
        // Simulate payment processing logic here
        // In real-world, integrate with a payment gateway
        System.out.println("Payment processed successfully for amount: " + amount);
    }
}
