package com.eventcafecloud.event.repository;

import com.eventcafecloud.cafe.Cafe;
import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByUserAndCafe(User user, Cafe cafe);

}
