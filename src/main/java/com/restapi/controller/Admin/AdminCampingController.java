package com.restapi.controller.Admin;

import com.restapi.model.Role;
import com.restapi.request.CampingRequest;
import com.restapi.response.CampingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/admin/camping")
@RolesAllowed(Role.ADMIN)
public class AdminCampingController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CampingService campingService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllCamping()
    {
        CampingResponse campingResponse = campingService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createCamping(@Valid @RequestBody CampingRequest campingRequest)
    {
        CampingResponse campingResponse = campingService.createCamping(campingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateCamping(@Valid @RequestBody CampingRequest campingRequest)
    {
        CampingResponse campingResponse = campingService.updateCamping(campingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteCamping(@PathVariable @NotNull @Min(value = 1, message = "ID must be greater than or equal to 1") Long id)
    {
        CampingResponse campingResponse = campingService.deleteCamping(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
