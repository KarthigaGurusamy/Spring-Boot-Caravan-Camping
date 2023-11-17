package com.restapi.request;

import com.restapi.model.Location;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
public class StaffRequest {

    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotEmpty
    @Size(min = 5, message = "Staff name should have at least 5 characters")
    private String staffName;

    @NotNull
    @Min(value = 1, message = "Location Id must be greater than or equal to 1")
    private Long locationId;


}
