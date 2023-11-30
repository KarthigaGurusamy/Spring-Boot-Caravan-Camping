package com.restapi.dto;

import com.restapi.model.Camping;
import com.restapi.request.CampingRequest;
import com.restapi.response.CampingResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CampingDto {
    public CampingResponse mapToCampingResponse(List<Camping> campingList) {
        CampingResponse campingResponse = new CampingResponse();

        ArrayList<CampingRequest> campingRequests = new ArrayList<>();
        for (Camping camping : campingList) {
            campingRequests.add(new CampingRequest(camping.getId(), camping.getCampingName(), camping.getDescription(), camping.getPhoto()));
        }

        campingResponse.setCampingResponseList(campingRequests);
        return campingResponse;
    }

    public Camping mapToCamping(CampingRequest campingRequest) {
        Camping camping = new Camping();
        if (campingRequest.getId() != null) {
            camping.setId(campingRequest.getId());
        }
        camping.setCampingName(campingRequest.getCampingName());
        camping.setPhoto(campingRequest.getPhoto());
        camping.setDescription(campingRequest.getDescription());
        camping.setPhoto(campingRequest.getPhoto());

        return camping;
    }

    public Camping mapToCampingOptional(Optional<Camping> campingOptional) {
        Camping camping = new Camping();
        camping.setId(campingOptional.get().getId());

        camping.setCampingName(campingOptional.get().getCampingName());
        camping.setPhoto(campingOptional.get().getPhoto());
        camping.setDescription(campingOptional.get().getDescription());
        return camping;
    }
}
