package com.restapi.repository;

import com.restapi.model.BookedUsers;
import com.restapi.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<BookedUsers, Long> {
}
