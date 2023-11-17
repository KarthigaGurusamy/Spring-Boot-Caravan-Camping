package com.restapi.response;

import com.restapi.request.CampingRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CampingResponse {

    private List<CampingRequest> campingResponseList = new ArrayList<>();
}
