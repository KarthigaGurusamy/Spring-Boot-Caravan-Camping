package com.restapi.controller.Admin;

import com.restapi.model.Camping;
import com.restapi.model.Role;
import com.restapi.request.CampingRequest;
import com.restapi.response.CampingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CampingService;
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

@RestController
@RequestMapping("/api/admin/camping")
@RolesAllowed(Role.ADMIN)
public class AdminCampingController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CampingService campingService;
    @Autowired
    private StorageService storageService;


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllCamping()
    {
        CampingResponse campingResponse = campingService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getAllCamping(@PathVariable Long id)
    {
        Camping camping = campingService.findCampingById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(camping);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value="/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createCamping(@RequestParam("photo") MultipartFile photo,
                                                     @RequestParam("campingName") String campingName,
                                                     @RequestParam("description") String description)
    {
        String file = storageService.storeFile(photo);
        CampingRequest campingRequest = new CampingRequest();
        campingRequest.setCampingName(campingName);
        campingRequest.setDescription(description);
        campingRequest.setPhoto(file);

        CampingResponse campingResponse = campingService.createCamping(campingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(campingResponse.getCampingResponseList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping(value="/update",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> updateCamping(@RequestParam("photo") MultipartFile photo,
                                                     @RequestParam("campingName") String campingName,
                                                     @RequestParam("description") String description,
    @RequestParam("id") Long id)
    {
        String file = storageService.storeFile(photo);
        CampingRequest campingRequest = new CampingRequest();
        campingRequest.setCampingName(campingName);
        campingRequest.setId(id);
        campingRequest.setDescription(description);
        campingRequest.setPhoto(file);
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
