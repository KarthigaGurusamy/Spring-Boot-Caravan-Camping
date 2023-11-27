package com.restapi.service;

import com.restapi.dto.LocationDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Booking;
import com.restapi.model.Camping;
import com.restapi.model.Location;
import com.restapi.repository.CampingRepository;
import com.restapi.repository.LocationRepository;
import com.restapi.request.LocationRequest;
import com.restapi.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
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

    @Autowired
    private StorageService storageService;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }


    @Transactional
    public List<Location> createLocation(LocationRequest locationRequest) {
        Location location = locationDto.mapToLocation(locationRequest);
        Camping camping = campingRepository.findById(locationRequest.getCampingId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", locationRequest.getCampingId()));
        location.setCamping(camping);
        locationRepository.save(location);
        return findAll();
    }

    @Transactional
    public List<Location> updateLocation(LocationRequest locationRequest) {
        Location location = locationDto.mapToLocation(locationRequest);
        Camping camping = campingRepository.findById(locationRequest.getCampingId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", locationRequest.getCampingId()));
        location.setCamping(camping);
        locationRepository.save(location);
        return findAll();
    }

    public List<Location> deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return findAll();
    }

    public Location findById(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return locationDto.mapToLocationResponse(location);
    }

    public List<Location> findLocationByCampingId(Long id) {
        List<Location> optionalLocationList = locationRepository.findLocations(id).orElseThrow(() -> new ResourceNotFoundException("campingId", "campingId", id));
        return locationDto.mapToOptionalLocation(optionalLocationList);
    }

    public Location getLocation(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.get();
    }

    public File getFile(Long id) throws IOException {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", "id", id));

        Resource resource = storageService.loadFileAsResource(location.getPhoto());

        return resource.getFile();
    }
}
