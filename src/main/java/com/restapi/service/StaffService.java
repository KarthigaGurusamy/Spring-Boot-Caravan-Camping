package com.restapi.service;

import com.restapi.dto.LocationDto;
import com.restapi.dto.StaffDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Location;
import com.restapi.model.Staff;
import com.restapi.repository.LocationRepository;
import com.restapi.repository.StaffRepository;
import com.restapi.request.StaffRequest;
import com.restapi.response.StaffResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private StaffDto staffDto;

    public List<StaffResponse> findAll() {
        return staffDto.mapToStaff(staffRepository.findAll());
    }


    @Transactional
    public List<StaffResponse> allocateStaff(StaffRequest staffRequest) {

        Staff staff = staffDto.mapToStaffLocation(staffRequest);
        Location location = locationRepository.findById(staffRequest.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("LocationId",
                        "LocationId", staffRequest.getLocationId()));
        staff.setLocation(location);
        List<Staff> staffList = staffRepository.findAll();
        boolean isStaffAssigned = false;
        for(Staff s:staffList)
        {
            if(s.getLocation().getId()==staffRequest.getLocationId())
            {
                isStaffAssigned=true;break;
            }
        }

        if(!isStaffAssigned)
        {
            staffRepository.save(staff);
        }
        return findAll();

    }


}
