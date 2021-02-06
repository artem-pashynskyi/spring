package com.openapi.repository;

import com.openapi.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByName(String name);
    Location deleteByName(String name);
}
