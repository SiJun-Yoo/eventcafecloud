package com.eventcafecloud.common.bookmark;

import javax.persistence.*;

@Entity
public abstract class Bookmark {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bookmark_number")
    private Long number;
}
