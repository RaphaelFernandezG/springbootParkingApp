package com.example.springboot.parking.parkingcontroller;

import com.example.springboot.parking.parkingentity.TypeUser;
import com.example.springboot.parking.parkingservice.TypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/typeUser")
public class TypeUserController {
    @Autowired
    private TypeUserService typeUserService;

    @PostMapping("/newTypeUser")
    public void registerNewTypeUser(@Valid @RequestBody TypeUser typeUser){
        typeUserService.addNewTypeUser(typeUser);
    }

    @DeleteMapping("/delTypeUser")
    public void deleteTypeUser(@Valid@RequestBody TypeUser typeUser){
        typeUserService.deleteTypeUser(typeUser);
    }

    @GetMapping("/listTypeUsers")
    public List<TypeUser> listUsers(){
        return typeUserService.listTypeUser();
    }
}
