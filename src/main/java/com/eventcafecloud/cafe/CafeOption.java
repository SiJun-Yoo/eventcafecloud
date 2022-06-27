package com.eventcafecloud.cafe;

import javax.persistence.*;

@Entity
public class CafeOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cafeOptionNumber;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Cafe cafe;
}
