package com.restapi.dto;

import com.restapi.model.Staff;
import com.restapi.request.StaffRequest;
import org.springframework.stereotype.Component;

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
}
