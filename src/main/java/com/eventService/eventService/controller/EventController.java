package com.eventService.eventService.controller;


import com.eventService.eventService.dto.CreateEventRequest;
import com.eventService.eventService.service.EventService;
import com.eventService.eventService.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/add-event")
    public ResponseEntity<Event> addEvent(@RequestBody CreateEventRequest eventRequest) {
        Event newEvent = eventService.addEvent(eventRequest);
        return ResponseEntity.ok(newEvent);
    }
}
