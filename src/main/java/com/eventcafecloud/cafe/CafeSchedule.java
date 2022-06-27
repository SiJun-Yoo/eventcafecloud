package com.eventcafecloud.cafe;

import com.eventcafecloud.common.base.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CafeSchedule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_schedule_number")
    private Long cafeScheduleNumber;

    private LocalDate cafeScheduleStartDate;

    private LocalDate cafeScheduleEndDate;

    private String cafeScheduleInfo;

    @Enumerated(EnumType.STRING)
    private CafeScheduleType cafeScheduleType;

    private Integer cafeSchedulePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_number")
    private Cafe cafe;
}