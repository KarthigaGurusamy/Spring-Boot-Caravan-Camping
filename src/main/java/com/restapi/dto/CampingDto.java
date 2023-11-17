package com.restapi.dto;

import com.restapi.model.Camping;
import com.restapi.request.CampingRequest;
import com.restapi.response.CampingResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampingDto {
    public CampingResponse mapToCampingResponse(List<Camping> campingList) {
        CampingResponse campingResponse = new CampingResponse();

        ArrayList<CampingRequest> campingRequests = new ArrayList<>();
        for(Camping camping:campingList)
        {
            campingRequests.add(new CampingRequest(camping.getId(),camping.getCampingName(),camping.getDescription(),camping.getPhoto()));
        }

        campingResponse.setCampingResponseList(campingRequests);
        return campingResponse;
    }

    public Camping mapToCamping(CampingRequest campingRequest) {
        Camping camping = new Camping();
        if(campingRequest.getId()!=null)
        {
            camping.setId(campingRequest.getId());
        }
        camping.setCampingName(campingRequest.getCampingName());
        camping.setPhoto(campingRequest.getPhoto());
        camping.setDescription(campingRequest.getDescription());
        return camping;
    }
}
