package com.restapi.controller.Admin;

import com.restapi.Utils.ImageUtils;
import com.restapi.model.Location;
import com.restapi.model.Role;
import com.restapi.request.CampingRequest;
import com.restapi.request.LocationRequest;
import com.restapi.response.CampingResponse;
import com.restapi.response.LocationResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.LocationService;
import com.restapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/location")
@RolesAllowed(Role.ADMIN)
public class AdminLocationController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private LocationService locationService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllLocation() {
        List<Location> locationList = locationService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getLocationById(@PathVariable @NotNull @Min(value = 1, message = "ID must be greater than or equal to 1") Long id) {
        Location location = locationService.findById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(location);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Location location = locationService.getLocation(id);
//        return new ResponseEntity<byte[]>(ImageUtils.decompressImage(location.getPhoto()), HttpStatus.OK);
        System.out.println(location.getPhoto());
        return ResponseEntity.ok().body(ImageUtils.decompressImage(location.getPhoto()));
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createLocation(@RequestParam("photo") MultipartFile photo,
                                                      @RequestParam("campingId") Long campingId,
                                                      @RequestParam("address") String address,
                                                      @RequestParam("name") String name,
                                                      @RequestParam("caravanName") String caravanName,
                                                      @RequestParam("caravanCapacity") Integer caravanCapacity,
                                                      @RequestParam("price") Double price,
                                                      @RequestParam("stayCount") Integer stayCount) throws IOException {

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setAddress(address);
        locationRequest.setName(name);
        locationRequest.setPhoto(photo.getBytes());
        locationRequest.setCampingId(campingId);
        locationRequest.setCaravanName(caravanName);
        locationRequest.setPrice(price);
        locationRequest.setCaravanCapacity(caravanCapacity);
        locationRequest.setStayCount(stayCount);

        String file = storageService.storeFile(photo);

        List<Location> locationList = locationService.createLocation(locationRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateLocation(@Valid @RequestBody LocationRequest locationRequest) {
        List<Location> locationList = locationService.updateLocation(locationRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteLocation(@PathVariable @NotNull @Min(value = 1, message = "ID must be greater than or equal to 1") Long id) {
        List<Location> locationList = locationService.deleteLocation(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(locationList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
