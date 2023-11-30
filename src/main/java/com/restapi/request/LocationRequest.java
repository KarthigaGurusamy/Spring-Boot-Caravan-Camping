package com.restapi.request;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationRequest {


//    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotNull(message = "campingId should not be empty")
    @Min(value = 1, message = "campingId must be greater than or equal to 1")
    private Long campingId;

    @Min(value = 1, message = "staffId must be greater than or equal to 1")
    private Long staffId;

    @NotEmpty
    @Size(min = 20, message = "Address should have at least 20 characters")
    private String address;

    @NotEmpty
    @Size(min = 5, message = "Name should have at least 5 characters")
    private String name;

    @NotEmpty
    @Size(min = 5, message = "Caravan name should have at least 5 characters")
    private String caravanName;

    private String campingName;

    @NotNull(message = "caravan capacity should not empty")
    @Min(value = 1, message = "Caravan capacity must be greater than or equal to 1")
    private Integer caravanCapacity;


    @NotNull
    @Min(value = 500, message = "Price must be greater than or equal to 500")
    private Double price;

    @NotNull
    @Min(value = 1, message = "StayCount must be greater than or equal to 1")
    private Integer stayCount;

    private String photo;


}
