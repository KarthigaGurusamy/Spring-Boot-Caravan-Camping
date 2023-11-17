package com.restapi.controller.User;

import com.restapi.model.Location;
import com.restapi.model.Role;
import com.restapi.request.BookingRequest;
import com.restapi.request.LocationRequest;
import com.restapi.response.BookingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserBookingService;
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
@RequestMapping("/api/user/bookings")
@RolesAllowed(Role.USER)
public class UserBookingsController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserBookingService userBookingService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBookings(@Valid @RequestBody BookingRequest bookingRequest)
    {
        List<BookingResponse> bookingResponses = userBookingService.findAll(bookingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createBooking(@Valid @RequestBody BookingRequest bookingRequest)
    {
        List<BookingResponse> bookingResponses = userBookingService.createCamping(bookingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<APIResponse> updateBooking(@Valid @RequestBody BookingRequest bookingRequest)
    {
        List<BookingResponse> bookingResponses = userBookingService.updateCamping(bookingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteBooking(@PathVariable @NotNull @Min(value = 1, message = "ID must be greater than or equal to 1") Long id)
    {
        List<BookingResponse> bookingResponses = userBookingService.deleteCamping(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
