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

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] photo;
    @Column(nullable = false, length = 100)
    private String caravanName;

    @Column(nullable = false)
    private Integer caravanCapacity;


    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer stayCount;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "staff_id",referencedColumnName = "id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "camping_id",referencedColumnName ="id")
    private Camping camping;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
