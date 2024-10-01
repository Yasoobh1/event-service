package com.eventService.eventService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventService.eventService.model.*;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    // You can add custom queries here if needed
}
