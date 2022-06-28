package com.eventcafecloud.event.domain;

import com.eventcafecloud.cafe.Cafe;
import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.event.domain.type.EventCategory;
import com.eventcafecloud.event.dto.EventCreateRequestDto;
import com.eventcafecloud.event.dto.EventUpdateRequestDto;
import com.eventcafecloud.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Event extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_number")
    @Id
    private Long eventNumber;

    @Column(nullable = false)
    private String eventName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventCategory eventCategory;

    @Column(nullable = false)
    private LocalDate eventStartDate;

    @Column(nullable = false)
    private LocalDate eventEndDate;

    @Column(nullable = false)
    private String eventInfo;

    @Column(nullable = false)
    private Integer eventPrice;

    @Column(nullable = false)
    private Boolean eventCancelAvail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_number")
    private Cafe cafe;

    @OneToMany(
            mappedBy = "event",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<EventImage> eventImage = new ArrayList<>();

    @Builder
    public Event(EventCreateRequestDto requestDto, User user, Cafe cafe) {
        this.eventName = requestDto.getEventName();
        this.eventCategory = requestDto.getEventCategory();
        this.eventStartDate = requestDto.getEventStartDate();
        this.eventEndDate = requestDto.getEventEndDate();
        this.eventInfo = requestDto.getEventInfo();
        this.eventPrice = requestDto.getEventPrice();
        this.eventCancelAvail = true;
    }

    public void updateEvent(EventUpdateRequestDto requestDto) {
        this.eventName = requestDto.getEventName();
        this.eventInfo = requestDto.getEventInfo();
    }

    // Event에서 이미지 파일 처리를 위해
    public void addEventImage(EventImage eventImage) {
        this.eventImage.add(eventImage);

        // 이미지 파일이 저장되어 있지 않은 경우
        if (eventImage.getEvent() != this)
            eventImage.setEvent(this);
    }
}
