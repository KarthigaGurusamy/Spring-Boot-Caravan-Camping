package com.restapi.request;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckBookingRequest {


    @NotNull
    @Future(message = "Date should be in future")
    private Date fromDate;

    @NotNull
    @Future(message = "Date should be in future")
    private Date toDate;

    @NotNull(message = "LocationId should not be empty")
    @Min(value = 1, message = "LocationId must be greater than or equal to 1")
    private Long locationId;


}
