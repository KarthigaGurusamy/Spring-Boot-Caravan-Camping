package com.restapi.response;

import com.restapi.request.CampingRequest;
import com.restapi.request.LocationRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LocationResponse {

    private List<LocationRequest> locationRequestList = new ArrayList<>();
}
