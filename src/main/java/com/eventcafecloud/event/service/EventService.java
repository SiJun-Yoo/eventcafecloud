package com.eventcafecloud.event.service;

import com.eventcafecloud.cafe.Cafe;
import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.domain.EventImage;
import com.eventcafecloud.event.dto.*;
import com.eventcafecloud.event.repository.EventRepository;
import com.eventcafecloud.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventReadResponseDto> getEvents() {
        List<Event> event = eventRepository.findAll();
        List<EventReadResponseDto> result = new ArrayList<>();

        for (int i = 0; i < event.size(); i++) {
            EventReadResponseDto eventReadResponseDto = new EventReadResponseDto(event.get(i));
            result.add(eventReadResponseDto);
        }
        return result;
    }

    public EventCreateResponseDto createEvent(EventCreateRequestDto requestDto, User user, Cafe cafe) {
        Event event = new Event(requestDto, user, cafe);
        Event eventResult = eventRepository.save(event);
        return EventCreateResponseDto.from(eventResult);
    }

    @Transactional
    public EventUpdateResponseDto updateEvent(Long eventNumber, EventUpdateRequestDto requestDto) {
        Event event =  eventRepository.findById(eventNumber).orElseThrow(
                () -> new NullPointerException("해당 이벤트가 존재하지 않습니다.")
        );

        event.updateEvent(requestDto);
        EventUpdateResponseDto eventUpdateResponseDto = new EventUpdateResponseDto(event.getEventName(), event.getEventInfo(), event.getEventImage());
        return eventUpdateResponseDto;
    }

    // 이벤트 삭제
    public void deleteEvent(Long eventNumber) {
        eventRepository.deleteById(eventNumber);
    }
}
