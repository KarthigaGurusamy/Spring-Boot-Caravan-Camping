package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private long phoneNumber;

    @Column(nullable = false,length = 100)
    private String gender;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private AppUser appUser;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
