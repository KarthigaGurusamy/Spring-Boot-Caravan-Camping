package com.restapi.controller.User;

import com.restapi.model.Role;
import com.restapi.response.CampingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/user/camping")
@RolesAllowed(Role.USER)
public class CampingController {
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
}
