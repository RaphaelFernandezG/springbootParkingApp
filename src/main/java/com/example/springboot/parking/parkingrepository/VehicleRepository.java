package com.example.springboot.parking.parkingrepository;

import com.example.springboot.parking.parkingentity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findVehicleByPlaca(String placa);

    //void updateBySalida(Vehicle vehicle1);
    //Optional<Vehicle> findVehicleById(Long id);
}
