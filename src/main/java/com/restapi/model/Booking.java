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
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookLocation_id",referencedColumnName = "id")
    private BookedLocation bookedLocation;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "paymentStatus_id",referencedColumnName = "id")
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName ="id")
    private AppUser appUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private List<BookedUsers> bookedUsersList=new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
