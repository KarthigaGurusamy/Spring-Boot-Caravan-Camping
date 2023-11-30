package com.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookedLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false)
    private Long locationId;

    @OneToMany(mappedBy = "bookedLocation")
    private List<Booking> booking = new ArrayList<>();

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    @Column(nullable = false, length = 100)
    private String caravanName;

    @Column(nullable = false)
    private Integer caravanCapacity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stayCount;


    @Column(nullable = false, length = 100)
    private String campingName;

    @Column(nullable = false, length = 200)
    private String description;

    @Column
    private String campingPhoto;
    @Column
    private String locationPhoto;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
