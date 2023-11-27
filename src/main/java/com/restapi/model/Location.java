package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 200)
    private String name;

    @Column
    private String photo;

    @Column(nullable = false, length = 100)
    private String caravanName;

    @Column(nullable = false)
    private Integer caravanCapacity;


    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stayCount;

    @OneToOne(mappedBy = "location",cascade = CascadeType.ALL)
    private Staff staff;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "camping_id",referencedColumnName ="id")
    private Camping camping;

    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
