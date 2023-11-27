package com.restapi.response;

import com.restapi.request.CampingRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StaffResponse {

    private Long id;
    private String staffName;
    private String locationName;
    private String campingName;
    private Long locationId;
}
