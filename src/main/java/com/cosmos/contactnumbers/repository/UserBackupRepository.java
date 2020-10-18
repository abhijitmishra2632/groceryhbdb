package com.cosmos.contactnumbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmos.contactnumbers.model.backup.UserBackup;

public interface UserBackupRepository extends JpaRepository<UserBackup, Long>{

}
