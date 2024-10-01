package com.eventService.eventService.service;

import com.eventService.eventService.repository.EventRepository;
import com.eventService.eventService.repository.TicketRepository;
import com.eventService.eventService.model.BookingEntity;
import com.eventService.eventService.model.Event;
import com.eventService.eventService.repository.BookingRepository;
import com.eventService.eventService.model.TicketEntity;
import com.eventService.eventService.dto.AddTicketTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TicketService {
    @Autowired
    private EventService eventService; // Calls Event Service via Feign or RestTemplate
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public BookingEntity bookTicket(Long eventId, int tickets, String ticketType, Long userId) {
        Event event = eventService.getEvent(eventId).orElseThrow(() -> new RuntimeException("Event not found"));

        if (event.getAvailableTickets() < tickets) {
            throw new RuntimeException("Not enough tickets available");
        }

        event.setAvailableTickets(event.getAvailableTickets() - tickets);
        eventService.createEvent(event); // Update event

        BookingEntity booking = new BookingEntity();
        booking.setEventId(eventId);
        booking.setNumberOfTickets(tickets);
        booking.setTicketType(ticketType);
        booking.setUserId(userId);

        // Save booking and return
        return bookingRepository.save(booking);
    }

    public BookingEntity cancelBooking(Long bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setCancelled(true);
        // Increase available tickets for the event
        Event event = eventService.getEvent(booking.getEventId()).orElseThrow(() -> new RuntimeException("Event not found"));
        event.setAvailableTickets(event.getAvailableTickets() + booking.getNumberOfTickets());
        eventService.createEvent(event); // Update event

        return bookingRepository.save(booking);
    }

    public TicketEntity addTicketType(AddTicketTypeRequest ticketTypeRequest) {
        // Check if event exists
        Optional<Event> eventOptional = eventRepository.findById(ticketTypeRequest.getEventId());
        if (!eventOptional.isPresent()) {
            throw new RuntimeException("Event not found");
        }

        // Check if the ticket type already exists for the event
        Optional<TicketEntity> ticketOptional = ticketRepository.findByEventIdAndTicketType(
                ticketTypeRequest.getEventId(), ticketTypeRequest.getTicketType());
        if (ticketOptional.isPresent()) {
            throw new RuntimeException("Ticket type already exists for this event");
        }

        // Create a new ticket entity for the event
        TicketEntity ticket = new TicketEntity();
        ticket.setEventId(ticketTypeRequest.getEventId());
        ticket.setTicketType(ticketTypeRequest.getTicketType());
        ticket.setPrice(ticketTypeRequest.getPrice());
        ticket.setQuantity(ticketTypeRequest.getQuantity());

        // Save the ticket type in the database
        return ticketRepository.save(ticket);
    }
}
