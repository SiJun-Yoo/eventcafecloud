package com.eventcafecloud.event.domain;

import com.eventcafecloud.common.fileutil.Image;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EventImage extends Image {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_image_number")
    @Id
    private Long id;

    @Column(nullable = false)
    private String eventImageUrl;

    @Column(nullable = true)
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_number")
    private Event event;


}
