package com.example.springboot.parking.parkingcontroller;

import com.example.springboot.parking.parkingentity.TypeUser;
import com.example.springboot.parking.parkingentity.User;
import com.example.springboot.parking.parkingrequest.EmailRequest;
import com.example.springboot.parking.parkingrequest.RequestUser;
import com.example.springboot.parking.parkingservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/newUser")
    public void registerNewUser(@Valid @RequestBody RequestUser request){
        userService.addNewUserRequest(request);
    }

    @DeleteMapping("/delUser")
    public void deleteUser(@Valid @RequestBody RequestUser requestUser){
        userService.deleteUserRequest(requestUser);
    }

    @GetMapping("/listUsers")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody RequestUser requestUser){
        userService.validateLogin(requestUser);
    }

    @PutMapping(path = "/updateUser/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String cedula,
            @RequestParam(required = false) String direction,
            @RequestParam(required = false) String email,
            /*@RequestParam(required = false) Long typeUserId,*/
            @RequestParam(required = false) String password){
        userService.updateUser(userId, name, cedula, direction, email, /*typeUserId,*/ password);

    }

    /*@PostMapping("/sendEmail")
    public void sendEmail(@Valid @RequestBody EmailRequest emailRequest){
        userService.sendEmailRequest(emailRequest);

    }*/
}
