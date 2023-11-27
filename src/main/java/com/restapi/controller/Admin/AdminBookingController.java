package com.restapi.controller.Admin;


import com.restapi.model.Role;
import com.restapi.response.BookingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/booking")
@RolesAllowed(Role.ADMIN)
public class AdminBookingController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserBookingService userBookingService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBookings()
    {
        List<BookingResponse> bookingResponses = userBookingService.findAllUsersBooking();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
