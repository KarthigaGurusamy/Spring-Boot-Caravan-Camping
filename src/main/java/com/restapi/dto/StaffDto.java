package com.restapi.dto;

import com.restapi.model.Staff;
import com.restapi.request.StaffRequest;
import com.restapi.response.StaffResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaffDto {
    public Staff mapToStaffLocation(StaffRequest staffRequest) {

        Staff staff = new Staff();
        if(staffRequest.getId()!=null)
        {
            staff.setId(staffRequest.getId());

        }
        staff.setStaffName(staffRequest.getStaffName());
        return staff;
    }

    public List<StaffResponse> mapToStaff(List<Staff> list) {
        List<StaffResponse> staffResponseList = new ArrayList<>();
        for(Staff staff:list)
        {
            StaffResponse staffResponse = new StaffResponse();
            staffResponse.setCampingName(staff.getLocation().getCamping().getCampingName());
            staffResponse.setId(staff.getId());
            staffResponse.setStaffName(staff.getStaffName());
            staffResponse.setLocationName(staff.getLocation().getAddress());
            staffResponse.setLocationId(staff.getLocation().getId());
            staffResponseList.add(staffResponse);
        }
        return staffResponseList;
    }
}
