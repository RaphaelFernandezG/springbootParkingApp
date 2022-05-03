package com.example.springboot.parking.parkingrepository;

import com.example.springboot.parking.parkingentity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByCedula(String cedula);

    Optional<User> findUserByEmail(String email);
}
