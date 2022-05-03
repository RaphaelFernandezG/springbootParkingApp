package com.example.springboot.parking.parkingcontroller;

import com.example.springboot.parking.parkingentity.RegistrationVehicles;
import com.example.springboot.parking.parkingentity.Vehicle;
import com.example.springboot.parking.parkingrequest.EmailRequest;
import com.example.springboot.parking.parkingrequest.VehicleRequest;
import com.example.springboot.parking.parkingservice.VehicleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    @PostMapping("/regVehicle")
    public void registerNewVehicle(@Valid @RequestBody VehicleRequest request){
        vehicleService.addNewVehicleRequest(request);
    }

    @PostMapping("/regExitVehicle")
    public void registerNewExitVehicle(@Valid @RequestBody Vehicle vehicle)throws JsonProcessingException{
        vehicleService.regExitVehicle(vehicle);
    }

    @DeleteMapping("/delVehicle")
    public void  deleteVehicle(@Valid @RequestBody Vehicle vehicle) throws JsonProcessingException {
        vehicleService.delVehicle(vehicle);
    }

    @GetMapping("/listVehicles")
    public List<Vehicle> listVehicles(){
        return vehicleService.listVehicle();
    }

    @GetMapping(path = "/findVehicle/{idVehicle}")
    public Optional<Vehicle> findVehicleByID(@PathVariable("idVehicle")Long idVehicle){
        return vehicleService.findVehicleById(idVehicle);
    }

    @PostMapping("/sendEmail")
    public void sendEmail(@Valid@RequestBody EmailRequest emailRequest){
        vehicleService.sendEmailRequest(emailRequest);

    }

    @GetMapping("/listRegistrationVehicles")
    public List<RegistrationVehicles> listRegistrationVehicles(){
        return vehicleService.listRegistrationVehicles();
    }





}
