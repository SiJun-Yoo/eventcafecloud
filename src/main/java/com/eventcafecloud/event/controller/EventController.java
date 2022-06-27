package com.eventcafecloud.event.controller;

import com.eventcafecloud.cafe.Cafe;
import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.dto.EventRequestDto;
import com.eventcafecloud.event.dto.EventUpdateRequestDto;
import com.eventcafecloud.event.service.EventService;
import com.eventcafecloud.user.domain.User;
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
        return eventService.getEvents();
    }

    // 신규 이벤트 예약
    @PostMapping("/api/events")
    public Event createEvent(@RequestBody EventRequestDto requestDto, User user, Cafe cafe) {   // Authenti 추가
        // Long userNumber = User.getUserNumber();
        Event event = eventService.createEvent(requestDto, user, cafe);
        return event;
    }

    // 이벤트 수정
    @PutMapping("/api/events/{evnetNumber}")
    public Event updateEvent(@PathVariable Long eventNumber, @RequestBody EventUpdateRequestDto requestDto){
        return eventService.updateEvent(eventNumber, requestDto);
    }

    // 이벤트 삭제
    @DeleteMapping("/api/events/{eventNumber}")
    public Long deleteEvent(@PathVariable Long eventNumber) {
        eventService.deleteEvent(eventNumber);
        return eventNumber;
    }

    // 카테고리별 이벤트 목록 조회

}

