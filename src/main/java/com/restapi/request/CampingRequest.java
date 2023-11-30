package com.restapi.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CampingRequest {

//    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotEmpty
    @Size(min = 5, message = "Camping Name should have at least 5 characters")
    private String campingName;

    @NotEmpty
    @Size(min = 20, message = "Description should have at least 50 characters")
    private String description;

    private String photo;





}
