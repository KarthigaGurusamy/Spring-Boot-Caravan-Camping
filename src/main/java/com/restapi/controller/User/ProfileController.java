package com.restapi.controller.User;

import com.restapi.model.Location;
import com.restapi.model.Profile;
import com.restapi.model.Role;
import com.restapi.request.LocationRequest;
import com.restapi.request.ProfileRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user/profile")
@RolesAllowed(Role.USER)
public class ProfileController {
    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private ProfileService profileService;


    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateUserProfile(@Valid @RequestBody ProfileRequest profileRequest)
    {
        Profile profile = profileService.updateUserProfile(profileRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(profile);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
