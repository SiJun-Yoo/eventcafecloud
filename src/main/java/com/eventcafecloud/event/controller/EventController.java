package com.eventcafecloud.event.controller;

import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.dto.EventRequestDto;
import com.eventcafecloud.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // 등록된 모든 이벤트 목록 조회
    @GetMapping("/api/events")
    public List<Event> getEvents() {
        List<Event> events = eventService.getEvents();
        return events;
    }

    // 신규 이벤트 예약
    @PostMapping("/api/events")
    public Event createEvent(@RequestBody EventRequestDto requestDto) {
        Event event = eventService.createEvent(requestDto);
        return event;
    }

    // 이벤트 수정
    @PutMapping("/api/events/{id}")
    public Long updateEvent(@PathVariable Long id, @RequestBody EventRequestDto requestDto)

    // 이벤트 삭제

    // 카테고리별 이벤트 목록 조회

}

