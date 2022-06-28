package com.eventcafecloud.event.repository;

import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.domain.EventImage;
import com.eventcafecloud.event.dto.EventImageRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventImageRepository extends JpaRepository<EventImage, Long> {
    // List<EventImage> findeAllByEvent(Event event);
}
