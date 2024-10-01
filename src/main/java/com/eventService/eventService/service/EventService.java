package com.eventService.eventService.service;

import com.eventService.eventService.repository.EventRepository;
import com.eventService.eventService.model.Event;
import com.eventService.eventService.dto.CreateEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> searchEvents(String query) {
        return eventRepository.findByNameContainingOrLocationContaining(query, query);
    }
    
    public Optional<Event> getEvent(Long id) {
        return eventRepository.findById(id);
    }



    public Event addEvent(CreateEventRequest eventRequest) {
        // Create a new Event object from the request data
        Event event = new Event();
        event.setName(eventRequest.getName());
        event.setEventDate(eventRequest.getEventDate());
        event.setLocation(eventRequest.getLocation());
        event.setTotalTickets(eventRequest.getTotalTickets());
        event.setAvailableTickets(eventRequest.getAvailableTickets());

        // Save the event in the database
        return eventRepository.save(event);
    }
}