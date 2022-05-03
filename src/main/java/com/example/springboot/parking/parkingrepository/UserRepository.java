package com.example.springboot.parking.parkingrepository;

import com.example.springboot.parking.parkingentity.TypeUser;
import com.example.springboot.parking.parkingentity.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByCedula(String cedula);

    Optional<User> findUserByEmail(String email);


    Optional<User> findByTypeUserId(TypeUser typeUser);
}
