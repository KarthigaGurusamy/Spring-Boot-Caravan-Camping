package com.restapi.request;

import com.restapi.model.AppUser;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileRequest {

    @Min(value = 1, message = "Id must be greater than or equal to 1")
    private Long id;

    @NotNull
    @Past(message = "Date of birth should be a past date")
    private Date dateOfBirth;

    @NotNull(message = "Phone number must not be null")
    @Min(value = 1, message = "Phone number must be greater than 0")
    private long phoneNumber;

    @NotEmpty
    @Size(min = 1, message = "Gender should have at least 5 characters")
    private String gender;

    @NotNull(message = "UserId must not be null")
    @Min(value = 1, message = "UserId must be greater than or equal to 1")
    private Long UserId;


}
