package com.example.springboot.parking.parkingservice;

import com.example.springboot.parking.parkingentity.TypeUser;
import com.example.springboot.parking.parkingentity.Vehicle;
import com.example.springboot.parking.parkingrepository.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TypeUserService {
    @Autowired
    private TypeUserRepository typeUserRepository;

    @ResponseStatus
    public void addNewTypeUser(TypeUser typeUser) {
        typeUserRepository.save(typeUser);
        throw new ResponseStatusException(HttpStatus.CREATED, "New Type User Has Been Registered");
    }

    public List<TypeUser> listTypeUser(){
        return typeUserRepository.findAll();
    }

    @ResponseStatus
    public void deleteTypeUser(TypeUser typeUser) {
        Optional<TypeUser> typeUserOptional = typeUserRepository.findById(typeUser.getId());

        if(typeUserOptional.isPresent()){
            typeUserRepository.delete(typeUser);
            throw new ResponseStatusException(HttpStatus.OK,"Typo de Usuario eliminado con exito ");

        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se encontro el tipo de usuario  ");

    }
}
