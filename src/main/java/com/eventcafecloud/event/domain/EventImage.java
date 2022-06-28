package com.eventcafecloud.event.domain;

import com.eventcafecloud.common.fileutil.Image;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class EventImage extends Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_image_number")
    @Id
    private Long eventImageNumber;

    @Column(nullable = false)
    private String eventImageUrl;

    @Column(nullable = true)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_number")
    private Event event;

    @Builder
    public EventImage(String eventImageUrl, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.eventImageUrl = eventImageUrl;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    // Event 정보 저장
    public void setEvent(Event event) {
        this.event = event;

        // Event에 현재 이미지 파일이 존재하지 않는다면
        if (!event.getEventImage().contains(this))
            event.getEventImage().add(this);
    }
}
