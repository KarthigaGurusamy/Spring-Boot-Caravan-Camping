package com.restapi.repository;

import com.restapi.model.BookedLocation;
import com.restapi.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserBookedRepository extends JpaRepository<BookedLocation, Long> {

    @Query("SELECT b FROM BookedLocation b WHERE DATE(b.fromDate) >= :fromDate AND DATE(b.toDate) <= :toDate AND b.locationId=:id")
    List<BookedLocation> checkAvailability(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("id") Long id);

}
