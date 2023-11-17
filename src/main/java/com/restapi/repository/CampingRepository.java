package com.restapi.repository;

import com.restapi.model.Camping;
import com.restapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Long> {

}