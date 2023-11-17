package com.restapi.controller.Admin;

import com.restapi.model.Location;
import com.restapi.model.Role;
import com.restapi.request.CampingRequest;
import com.restapi.request.LocationRequest;
import com.restapi.response.CampingResponse;
import com.restapi.response.LocationResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/admin/location")
@RolesAllowed(Role.ADMIN)
public class AdminLocationController {
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

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createLocation(@Valid @RequestBody LocationRequest locationRequest)
    {
        List<Location> locationList = locationService.createCamping(locationRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateLocation(@Valid @RequestBody LocationRequest locationRequest)
    {
        List<Location> locationList = locationService.updateCamping(locationRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteLocation(@PathVariable @NotNull @Min(value = 1, message = "ID must be greater than or equal to 1") Long id)
    {
        List<Location> locationList = locationService.deleteCamping(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
