package com.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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

    @OneToMany(mappedBy = "bookedLocation")
    private List<Booking> booking = new ArrayList<>();

    @Column(nullable = false)
    private Date fromDate;

    @Column(nullable = false)
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

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] campingPhoto;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] locationPhoto;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
