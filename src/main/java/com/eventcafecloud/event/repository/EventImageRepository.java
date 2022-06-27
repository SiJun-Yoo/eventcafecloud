package com.eventcafecloud.event.repository;

import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.domain.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventImageRepository extends JpaRepository<Event, Long> {
}
