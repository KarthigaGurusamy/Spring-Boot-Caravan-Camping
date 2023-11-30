package com.restapi.controller.Admin;

import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.request.StaffRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.StaffResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.StaffService;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@RolesAllowed(Role.ADMIN)
public class AdminUserDetailsController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllLocation()
    {
        List<AuthResponse> appUserList = userService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(appUserList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
