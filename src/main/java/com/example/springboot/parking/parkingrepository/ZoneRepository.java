package com.example.springboot.parking.parkingrepository;

import com.example.springboot.parking.parkingentity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
