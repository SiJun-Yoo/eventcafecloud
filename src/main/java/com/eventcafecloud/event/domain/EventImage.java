package com.eventcafecloud.event.domain;

import com.eventcafecloud.common.fileutil.Image;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EventImage extends Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
