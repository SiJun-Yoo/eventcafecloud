package com.eventcafecloud.cafe;

import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.user.domain.User;

import javax.persistence.*;

@Entity
public class CafeReview extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafeReviewNumber;

    private String reviewContent;

    private Integer reviewRating;

    private Boolean reviewStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;
}
