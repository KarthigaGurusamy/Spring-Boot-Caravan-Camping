package com.restapi.controller.Admin;

import com.restapi.model.Location;
import com.restapi.model.Role;
import com.restapi.model.Staff;
import com.restapi.request.LocationRequest;
import com.restapi.request.StaffRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/staff")
@RolesAllowed(Role.ADMIN)
public class StaffController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private StaffService staffService;


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllLocation()
    {
        List<Staff> staffList = staffService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(staffList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping("/allocate")
    public ResponseEntity<APIResponse> allocateStaff(@Valid @RequestBody StaffRequest staffRequest)
    {
        List<Staff> staffList = staffService.allocateStaff(staffRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(staffList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
