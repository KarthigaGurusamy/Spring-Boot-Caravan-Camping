package com.restapi.dto;

import com.restapi.model.BookedLocation;
import com.restapi.model.Booking;
import com.restapi.model.Location;
import com.restapi.request.BookingRequest;
import com.restapi.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookingDto {


    public List<BookingResponse> mapToResponse(List<Booking> bookingList) {

        List<BookingResponse> bookingResponseList = new ArrayList<>();
        for (Booking booking : bookingList) {
            BookingResponse bookingResponse = new BookingResponse();
//            bookingResponse.setBooking(booking);
            bookingResponse.setId(booking.getId());
            bookingResponse.setUserId(booking.getAppUser().getId());
            bookingResponse.setUserName(booking.getAppUser().getUsername());
            bookingResponse.setName(booking.getAppUser().getName());
            bookingResponse.setAddress(booking.getBookedLocation().getAddress());
            bookingResponse.setFromDate(booking.getBookedLocation().getFromDate());
            bookingResponse.setToDate(booking.getBookedLocation().getToDate());
            bookingResponse.setCampingName(booking.getBookedLocation().getCampingName());
            bookingResponse.setCaravanName(booking.getBookedLocation().getCaravanName());
            bookingResponse.setCaravanCapacity(booking.getBookedLocation().getCaravanCapacity());
            bookingResponse.setPrice(booking.getBookedLocation().getPrice());
            bookingResponse.setStayCount(booking.getBookedLocation().getStayCount());
            bookingResponse.setDescription(booking.getBookedLocation().getDescription());
            bookingResponse.setCampingPhoto(booking.getBookedLocation().getCampingPhoto());
            bookingResponse.setLocationPhoto(booking.getBookedLocation().getLocationPhoto());
            bookingResponseList.add(bookingResponse);

        }
        return bookingResponseList;
    }

    public BookedLocation mapToBookedLocation(Location location, BookingRequest bookingRequest) {
        BookedLocation bookedLocation = new BookedLocation();
        if (bookingRequest.getId() != null) {
            bookedLocation.setId(bookingRequest.getId());
        }
        bookedLocation.setAddress(location.getAddress());
        bookedLocation.setFromDate(bookingRequest.getFromDate());
        bookedLocation.setToDate(bookingRequest.getToDate());
        bookedLocation.setCampingName(location.getCamping().getCampingName());
        bookedLocation.setCaravanName(location.getCaravanName());
        bookedLocation.setCaravanCapacity(location.getCaravanCapacity());
        bookedLocation.setPrice(location.getPrice());
        bookedLocation.setStayCount(location.getStayCount());
        bookedLocation.setDescription(location.getCamping().getDescription());
        bookedLocation.setCampingPhoto(location.getCamping().getPhoto());
        bookedLocation.setLocationPhoto(location.getPhoto());
        return bookedLocation;
    }

    public BookedLocation mapToUpdatedBookedLocation(BookingRequest bookingRequest, Optional<Booking> booked) {
        BookedLocation bookedLocation = new BookedLocation();

        bookedLocation.setId(bookingRequest.getId());
        bookedLocation.setFromDate(bookingRequest.getFromDate());
        bookedLocation.setToDate(bookingRequest.getToDate());
        bookedLocation.setAddress(booked.get().getBookedLocation().getAddress());
        bookedLocation.setCampingName(booked.get().getBookedLocation().getCampingName());
        bookedLocation.setCaravanName(booked.get().getBookedLocation().getCaravanName());
        bookedLocation.setCaravanCapacity(booked.get().getBookedLocation().getCaravanCapacity());
        bookedLocation.setPrice(booked.get().getBookedLocation().getPrice());
        bookedLocation.setStayCount(booked.get().getBookedLocation().getStayCount());
        bookedLocation.setDescription(booked.get().getBookedLocation().getDescription());
        bookedLocation.setCampingPhoto(booked.get().getBookedLocation().getCampingPhoto());
        bookedLocation.setLocationPhoto(booked.get().getBookedLocation().getLocationPhoto());
        return bookedLocation;
    }

}
