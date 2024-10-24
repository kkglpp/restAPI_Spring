package com.server.healthapp.springHealthApp.repository;

import com.server.healthapp.springHealthApp.entity.SportEntity;
import com.server.healthapp.springHealthApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
