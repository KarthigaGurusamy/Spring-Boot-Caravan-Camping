package com.restapi.controller.User;

import com.restapi.model.Location;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/user/location")
@RolesAllowed(Role.USER)
public class LocationController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private LocationService locationService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllLocation()
    {
        List<Location> locationList = locationService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getLocationById(@PathVariable @NotNull @Min(value = 1, message = "ID must be greater than or equal to 1") Long id)
    {
        Location location = locationService.findById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(location);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
