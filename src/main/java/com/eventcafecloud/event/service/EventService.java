package com.eventcafecloud.event.service;

import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.dto.EventRequestDto;
import com.eventcafecloud.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.getEvents();
    }

    public Event createEvent(EventRequestDto requestDto) {
        Event event = new Event(requestDto);
        eventRepository.createEvent(event);
        return event;
    }

    public Event updateEvent(EventRequestDto requestDto) {
        Event event = eventRepository.getEvent(eventNumber);
    }
}
