package com.eventService.eventService.repository;


import com.eventService.eventService.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    Optional<TicketEntity> findByEventIdAndTicketType(Long eventId, String ticketType);
}
