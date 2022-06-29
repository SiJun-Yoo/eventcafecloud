package com.eventcafecloud.event.dto;

import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.event.domain.EventImage;
import com.eventcafecloud.event.domain.type.EventCategory;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 외부의 접근을 막기 위해
@Setter
@Getter
public class EventReadResponseDto {
    private Long eventNumber;
    private String eventName;
    private EventCategory eventCategory;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;
    private String eventInfo;
    private EventCafe cafe;
    private List<EventImage> eventImages;


    public EventReadResponseDto(Event event) {
        this.eventNumber = event.getEventNumber();
        this.eventName = event.getEventName();
        this.eventCategory = event.getEventCategory();
        this.eventStartDate = event.getEventStartDate();
        this.eventEndDate = event.getEventEndDate();
        this.eventInfo = event.getEventInfo();
        this.cafe = EventCafe.builder()
                .cafeNumber(event.getCafe().getCafeNumber())
                .cafeName(event.getCafe().getCafeName())
                .cafeZoneCode(event.getCafe().getCafeZoneCode())
                .cafeAddress(event.getCafe().getCafeAddress())
                .cafeAddressDetail(event.getCafe().getCafeAddressDetail())
                .build();
    }

    @Getter
    static class EventCafe {
        private long cafeNumber;
        private String cafeName;
        private Integer cafeZoneCode;
        private String cafeAddress;
        private String cafeAddressDetail;

        @Builder
        public EventCafe(Long cafeNumber, String cafeName, Integer cafeZoneCode, String cafeAddress, String cafeAddressDetail) {
        this.cafeNumber = cafeNumber;
        this.cafeName = cafeName;
        this.cafeZoneCode = cafeZoneCode;
        this.cafeAddress  = cafeAddress;
        this.cafeAddressDetail = cafeAddressDetail;
        }
    }
}