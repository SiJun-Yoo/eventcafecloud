package com.eventcafecloud.event.repository;

import com.eventcafecloud.event.domain.EventImage;
import com.eventcafecloud.event.dto.EventImageRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventImageRepository extends JpaRepository<EventImage, Long> {
    List<EventImage> findFirst(EventImageRequestDto requestDto);
}
