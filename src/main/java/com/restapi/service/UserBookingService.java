package com.restapi.service;

import com.restapi.dto.BookingDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.*;
import com.restapi.repository.*;
import com.restapi.request.BookingRequest;
import com.restapi.request.UserDetailsRequest;
import com.restapi.response.BookingResponse;
import com.restapi.response.UserDetailsResponse;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserBookingService {

    @Autowired
    private UserBookingRepository userBookingRepository;

    @Autowired
    private UserBookedRepository userBookedRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CampingRepository campingRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private BookingDto bookingDto;


    public List<BookingResponse> findAll(Long id) {
        List<Booking> bookings = userBookingRepository.findUserBookings(id)
                .orElseThrow(()-> new ResourceNotFoundException("userId","userId",id));
        return bookingDto.mapToResponse(bookings);

    }

    @Transactional
    public List<BookingResponse> createBooking(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        AppUser appUser = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("UserId",
                        "UserId", bookingRequest.getUserId()));

        Location location = locationRepository.findById(bookingRequest.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("LocationId",
                        "LocationId", bookingRequest.getLocationId()));

        PaymentStatus paymentStatus = paymentStatusRepository.findById(1L)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentStatusId",
                "PaymentStatusId", 1));


        booking.setAppUser(appUser);
        booking.setBookedLocation(bookingDto.mapToBookedLocation(location,bookingRequest));
        booking.setPaymentStatus(paymentStatus);
        userBookingRepository.save(booking);
        return findAll(bookingRequest.getUserId());

    }

    @Transactional
    public List<BookingResponse> updateBooking(BookingRequest bookingRequest) {


        Optional<Booking> bookedLocation = userBookingRepository.findById(bookingRequest.getLocationId());

        BookedLocation newBookedLocation  = bookingDto.mapToUpdatedBookedLocation(bookingRequest, bookedLocation);


        userBookedRepository.save(newBookedLocation);
        return findAll(bookingRequest.getUserId());
    }

    public List<BookingResponse> deleteBooking(Long id) {
        Booking booking = userBookingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id","Id",id));
        userBookingRepository.deleteById(id);
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setUserId(booking.getAppUser().getId());
        return findAll(bookingRequest.getUserId());
    }

    public List<BookingResponse> findAllUsersBooking() {
        List<Booking> bookings = userBookingRepository.findAll();
        return bookingDto.mapToResponse(bookings);
    }

    public String userDetailsForBooking(UserDetailsRequest userDetailsRequest) {
        Booking booking = userBookingRepository.findById(userDetailsRequest.getBookingId())
                .orElseThrow(()-> new ResourceNotFoundException("Id","Id", userDetailsRequest.getBookingId()));

        BookedUsers bookedUsers = bookingDto.mapToUserDetails(userDetailsRequest);
        bookedUsers.setBooking(booking);
        userDetailsRepository.save(bookedUsers);
        return "Success!";

    }
}
