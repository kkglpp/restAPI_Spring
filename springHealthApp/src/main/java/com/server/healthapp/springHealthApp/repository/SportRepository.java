package com.server.healthapp.springHealthApp.repository;

import com.server.healthapp.springHealthApp.Entity.SportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<SportEntity,Integer> {

}
