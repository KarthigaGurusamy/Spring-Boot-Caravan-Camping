package com.restapi.service;

import com.restapi.dto.LocationDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Camping;
import com.restapi.model.Location;
import com.restapi.repository.CampingRepository;
import com.restapi.repository.LocationRepository;
import com.restapi.request.LocationRequest;
import com.restapi.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationDto locationDto;

    @Autowired
    private CampingRepository campingRepository;
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public List<Location> createCamping(LocationRequest locationRequest) {
        Location location = locationDto.mapToLocation(locationRequest);
        Camping camping = campingRepository.findById(locationRequest.getCampingId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", locationRequest.getCampingId()));
        location.setCamping(camping);
        locationRepository.save(location);
        return findAll();
    }

    public List<Location> updateCamping(LocationRequest locationRequest) {
        Location location = locationDto.mapToLocation(locationRequest);
        Camping camping = campingRepository.findById(locationRequest.getCampingId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", locationRequest.getCampingId()));
        location.setCamping(camping);
        locationRepository.save(location);
        return findAll();
    }

    public List<Location> deleteCamping(Long id) {
        locationRepository.deleteById(id);
        return findAll();
    }

    public Location findById(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return locationDto.mapToLocationResponse(location);
    }
}
