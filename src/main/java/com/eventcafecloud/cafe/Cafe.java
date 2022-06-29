package com.eventcafecloud.cafe;

import com.eventcafecloud.common.base.BaseTimeEntity;
import com.eventcafecloud.event.domain.Event;
import com.eventcafecloud.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
public class Cafe extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafeNumber;

    private String cafeName;

    private Integer cafeZoneCode;

    private String cafeAddress;

    private String cafeAddressDetail;

    private Double cafeX;

    private Double cafeY;

    private String cafeInfo;

    private String cafeInfoDetail;

    private String precaution;

    private Integer cafeWeekdayPrice;

    private Integer cafeWeekendPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user;

    @OneToMany(mappedBy = "cafe")
    private List<CafeOption> cafeOptions = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<CafeImage> cafeImages = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<CafeReview> cafeReviews = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<CafeSchedule> cafeSchedules = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Event> events = new ArrayList<>();

}
