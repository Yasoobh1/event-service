package com.eventService.eventService.repository;

import com.eventService.eventService.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainingOrLocationContaining(String name, String location);

    Event save(Event event);

    Optional<Event> findById(Long id);
}