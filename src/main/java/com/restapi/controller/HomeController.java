package com.restapi.controller;

import com.restapi.model.Location;
import com.restapi.request.LoginRequest;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.CampingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CampingService;
import com.restapi.service.LocationService;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CampingService campingService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/location/all")
    public ResponseEntity<APIResponse> getAllLocation()
    {
        List<Location> locationList = locationService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/camping/all")
    public ResponseEntity<APIResponse> getAllCamping()
    {
        CampingResponse campingResponse = campingService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/camping-location/{id}")
    public ResponseEntity<APIResponse> getLocationsByCampingId(@PathVariable @Min(value = 1, message = "ID must be greater than or equal to 1") Long id)
    {
        List<Location> locationList = locationService.findLocationByCampingId(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
