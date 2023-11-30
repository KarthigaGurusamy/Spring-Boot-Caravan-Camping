package com.restapi.response;

import com.restapi.model.Booking;
import com.restapi.request.BookingRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BookingResponse {


    private Long id;

    private String address;

    private Long userId;
    private String userName;
    private String name;

    private Date fromDate;

    private Date toDate;

    private String caravanName;

    private Integer caravanCapacity;

    private Double price;

    private Integer stayCount;

    private String campingName;

    private String description;
    private String status;

    private String campingPhoto;

    private String locationPhoto;

}


