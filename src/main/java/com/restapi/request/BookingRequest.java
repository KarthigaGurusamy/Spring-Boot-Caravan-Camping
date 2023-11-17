package com.restapi.request;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingRequest {

    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotNull(message = "UserID should not be empty")
    @Min(value = 1, message = "UserId must be greater than or equal to 1")
    private Long userId;

    @NotNull(message = "LocationId should not be empty")
    @Min(value = 1, message = "LocationId must be greater than or equal to 1")
    private Long locationId;

    @NotNull
    @Future(message = "Date should be in future")
    private Date fromDate;

    @NotNull
    @Future(message = "Date should be in future")
    private Date toDate;


}
