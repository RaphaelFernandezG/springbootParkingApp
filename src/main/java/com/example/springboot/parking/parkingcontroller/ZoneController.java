package com.example.springboot.parking.parkingcontroller;

import com.example.springboot.parking.parkingentity.Zone;
import com.example.springboot.parking.parkingrequest.VehicleRequest;
import com.example.springboot.parking.parkingservice.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/zone")
public class ZoneController {
    /*@Autowired
    private ZoneService zoneService;

    @PostMapping("/regZone")
    public void registerNewZone(@Valid @RequestBody Zone zone){
        zoneService.addZone(zone);
    }*/
}
