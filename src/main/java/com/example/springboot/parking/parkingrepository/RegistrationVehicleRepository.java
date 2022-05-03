package com.example.springboot.parking.parkingrepository;

import com.example.springboot.parking.parkingentity.RegistrationVehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationVehicleRepository extends JpaRepository<RegistrationVehicles, Long> {
}
