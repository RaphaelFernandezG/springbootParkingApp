package com.example.springboot.parking.parkingrepository;

import com.example.springboot.parking.parkingentity.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Long> {
}
