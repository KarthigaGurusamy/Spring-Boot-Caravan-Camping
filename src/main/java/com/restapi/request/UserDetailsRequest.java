package com.restapi.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetailsRequest {

//    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotNull
    @Min(value = 1, message = "Booking Id must be greater than or equal to 1")
    private Long bookingId;

    @NotEmpty
    @Size(min = 5, message = "Name should have at least 5 characters")
    private String name;

    @NotNull
    @Min(value = 0, message = "Location Id must be greater than or equal to 0")
    private Integer age;

    @NotEmpty
    @Size(min = 1, message = "Gender should have at least 1 characters")
    private String gender;

}
