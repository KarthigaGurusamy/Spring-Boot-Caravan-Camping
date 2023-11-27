package com.restapi.repository;

import com.restapi.model.Booking;
import com.restapi.model.Location;
import com.restapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("select l from Location l inner join l.camping c where c.id=?1")
    Optional<List<Location>> findLocations(Long id);
}
