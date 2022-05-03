package com.example.springboot.parking;

import com.example.springboot.parking.parkingcontroller.ZoneController;
import com.example.springboot.parking.parkingentity.Zone;
import com.example.springboot.parking.parkingrepository.ZoneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ParkingApplication {

	private ZoneRepository zoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}

	/*public void run(String... args)  {
		addZone();


	}



public void addZone(){
		Zone zone1=new Zone("Sombra", "Parqueadero con sombra todo el dia");
		Zone zone2=new Zone("Sol", "Parqueadero al sol todo el dia");
		Zone zone3=new Zone("MedioD", "Parqueadero con sombra solo en la mañana");
		Zone zone4=new Zone("MedioT", "Parqueadero con sombra solo en la tarde");

		List<Zone> list=Arrays.asList(zone1, zone2, zone3, zone4);
		list.stream().forEach(zoneRepository::save);
		}*/

}




