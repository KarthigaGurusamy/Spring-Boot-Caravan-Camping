package com.restapi.service;

import com.restapi.dto.LocationDto;
import com.restapi.dto.StaffDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Location;
import com.restapi.model.Staff;
import com.restapi.repository.LocationRepository;
import com.restapi.repository.StaffRepository;
import com.restapi.request.StaffRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StaffDto staffDto;

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }
    public List<Staff> allocateStaff(StaffRequest staffRequest) {

        Staff staff = staffDto.mapToStaffLocation(staffRequest);
        Location location = locationRepository.findById(staffRequest.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("LocationId",
                        "LocationId", staffRequest.getLocationId()));
        staff.setLocation(location);
        staffRepository.save(staff);
        return findAll();

    }


}
