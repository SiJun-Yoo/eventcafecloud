package com.eventcafecloud.event.service;

import com.eventcafecloud.cafe.Cafe;
import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.dto.EventRequestDto;
import com.eventcafecloud.event.dto.EventUpdateRequestDto;
import com.eventcafecloud.event.repository.EventRepository;
import com.eventcafecloud.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // 등록된 모든 이벤트 목록 조회
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    // 신규 이벤트 예약
    public Event createEvent(EventRequestDto requestDto, User user, Cafe cafe) {
        Event event = new Event(requestDto, user, cafe);
        eventRepository.save(event);
        return event;
    }

    // 이벤트 수정
    @Transactional
    public Event updateEvent(Long eventNumber, EventUpdateRequestDto requestDto) {
        Event event =  eventRepository.findById(eventNumber).orElseThrow(
                () -> new NullPointerException("해당 이벤트가 존재하지 않습니다.")
        );

        event.updateEvent(requestDto);
        return event;
    }

    // 이벤트 삭제
    public void deleteEvent(Long eventNumber) {
        eventRepository.deleteById(eventNumber);
    }


}
