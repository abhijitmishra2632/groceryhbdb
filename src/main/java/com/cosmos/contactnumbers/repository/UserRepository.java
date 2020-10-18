package com.cosmos.contactnumbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmos.contactnumbers.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
