package com.restapi.dto;

import com.restapi.model.Camping;
import com.restapi.model.Location;
import com.restapi.model.Staff;
import com.restapi.request.CampingRequest;
import com.restapi.request.LocationRequest;
import com.restapi.response.CampingResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LocationDto {

    public Location mapToLocation(LocationRequest locationRequest) {
        Location location = new Location();
        if (locationRequest.getId() != null) {
            location.setId(locationRequest.getId());
        }
        location.setPhoto(locationRequest.getPhoto());
        location.setAddress(locationRequest.getAddress());
        location.setPrice(locationRequest.getPrice());
        location.setCaravanName(locationRequest.getCaravanName());
        location.setCaravanCapacity(locationRequest.getCaravanCapacity());
        location.setStayCount(locationRequest.getStayCount());
        location.setName(locationRequest.getName());
        location.setPhoto(locationRequest.getPhoto());

        return location;
    }


    public Location mapToLocationResponse(Optional<Location> optionalLocation) {
        Location location = new Location();

        location.setId(optionalLocation.get().getId());

        location.setPhoto(optionalLocation.get().getPhoto());
        location.setAddress(optionalLocation.get().getAddress());
        location.setPrice(optionalLocation.get().getPrice());
        location.setCaravanName(optionalLocation.get().getCaravanName());
        location.setCaravanCapacity(optionalLocation.get().getCaravanCapacity());
        location.setStayCount(optionalLocation.get().getStayCount());
        location.setName(optionalLocation.get().getName());
        location.setPhoto(optionalLocation.get().getPhoto());

        return location;
    }

    public List<Location> mapToOptionalLocation(List<Location> optionalLocationList) {
        List<Location> locationList = new ArrayList<>();
        for (Location location : optionalLocationList) {

            Location locationObj = new Location();
            locationObj.setId(location.getId());
            locationObj.setPhoto(location.getPhoto());
            locationObj.setAddress(location.getAddress());
            locationObj.setPrice(location.getPrice());
            locationObj.setCaravanName(location.getCaravanName());
            locationObj.setCaravanCapacity(location.getCaravanCapacity());
            locationObj.setStayCount(location.getStayCount());
            locationObj.setName(location.getName());
            locationObj.setStaff(location.getStaff());
            locationObj.setPhoto(location.getPhoto());
            locationList.add(locationObj);
        }
        return locationList;
    }
}
