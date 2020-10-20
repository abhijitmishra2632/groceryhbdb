package com.cosmos.contactnumbers.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cosmos.contactnumbers.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
	@Query("SELECT e from Users e where e.addedDate =:date ")       // using @query
    List<Users> findByDate(@Param("date") LocalDate date);

}
