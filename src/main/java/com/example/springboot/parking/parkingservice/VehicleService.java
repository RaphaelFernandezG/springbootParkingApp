package com.example.springboot.parking.parkingservice;

import com.example.springboot.parking.parkingentity.RegistrationVehicles;
import com.example.springboot.parking.parkingentity.TypeUser;
import com.example.springboot.parking.parkingentity.User;
import com.example.springboot.parking.parkingentity.Vehicle;
import com.example.springboot.parking.parkingrepository.RegistrationVehicleRepository;
import com.example.springboot.parking.parkingrepository.TypeUserRepository;
import com.example.springboot.parking.parkingrepository.UserRepository;
import com.example.springboot.parking.parkingrepository.VehicleRepository;
import com.example.springboot.parking.parkingrequest.EmailRequest;
import com.example.springboot.parking.parkingrequest.VehicleRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.request.InvalidRequestStateException;
import com.sun.net.httpserver.HttpServer;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private RegistrationVehicleRepository registrationVehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeUserRepository typeUserRepository;

    @Autowired
    ObjectMapper objectMapper;

    @ResponseStatus
    public void addVehicle(Vehicle vehicle){
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByPlaca(vehicle.getPlaca());
        if(vehicleOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se puede Registrar Ingreso, ya existe la placa ");
        }
        System.out.println("Metodo Add Vehicle");
        vehicleRepository.save(vehicle);
        throw new ResponseStatusException(HttpStatus.CREATED,"Id: "+vehicle.getId() +" --> Id Generado Del Registro ");
    }

    @ResponseStatus
    public void regExitVehicle(Vehicle vehicle) throws JsonProcessingException{

        System.out.println(objectMapper.writeValueAsString(vehicle));

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByPlaca(vehicle.getPlaca());

        System.out.println(objectMapper.writeValueAsString(vehicleOptional));

        if(vehicleOptional.isPresent()){
            RegistrationVehicles regVehic=new RegistrationVehicles(vehicleOptional.get());

            System.out.println(objectMapper.writeValueAsString(regVehic));

            registrationVehicleRepository.save(regVehic);
            vehicleRepository.delete(vehicleOptional.get());
            throw new ResponseStatusException(HttpStatus.OK,"Salida ha Sido Registrada. Placa: "+vehicle.getPlaca());

        }
        System.out.println("Method Register Exit Vehicle");

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se Puede Registrar Salida placa, no existe la placa: "+vehicle.getPlaca());


    }

    @ResponseStatus
    public void delVehicle(Vehicle vehicle) throws JsonProcessingException {

        System.out.println(objectMapper.writeValueAsString(vehicle));

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByPlaca(vehicle.getPlaca());

        if(vehicleOptional.isPresent()){
            System.out.println(objectMapper.writeValueAsString(vehicleOptional.get()));

            vehicleRepository.delete(vehicleOptional.get());
            throw new ResponseStatusException(HttpStatus.OK,"Se ha Eliminado el Vehiculo ");

        }
        System.out.println("Metodo Del Vehicle");
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede Eliminar, no existe la placa ingresada ");


    }

    public List<Vehicle> listVehicle() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @ResponseStatus
    public void addNewVehicleRequest(VehicleRequest request) {

        Optional<Vehicle> userOptional = vehicleRepository.findVehicleByPlaca(request.getPlaca());
        List<Vehicle> listCount=vehicleRepository.findAll();
        System.out.println("Metodo Add Vehicle Request");
        if(listCount.size()<5){
            if(userOptional.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se puede Registrar Ingreso, ya existe la placa ");
            }
            Vehicle vehicle=new Vehicle(request.getPlaca());
            vehicleRepository.save(vehicle);
            throw new ResponseStatusException(HttpStatus.CREATED,"Id: "+vehicle.getId() +" --> Id Generado Del Registro ");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se puede Registrar, Ya se Llego a Maxima Capacidad ");


    }

    @ResponseStatus
    public void delVehicleRequest(VehicleRequest request) {
        Optional<Vehicle> userOptional = vehicleRepository.findVehicleByPlaca(request.getPlaca());
        if(userOptional.isPresent()) {
            Vehicle vehicle=new Vehicle(request.getPlaca());
            vehicleRepository.delete(vehicle);
            throw new ResponseStatusException(HttpStatus.OK, "Salida Registrada");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede Registrar Salida, no existe la placa ingresada ");
    }

    @ResponseStatus
    public void sendEmailRequest(EmailRequest emailRequest){
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByPlaca(emailRequest.getPlaca());
        Optional<TypeUser> typeUserOptional = typeUserRepository.findById(1L);
        Optional<User> userAdminOptional = userRepository.findByTypeUserId(typeUserOptional.get());
        System.out.println(userAdminOptional);
        if(vehicleOptional.isPresent()){
            Optional<User> userOptional = userRepository.findUserByEmail(emailRequest.getEmail());
            if(userOptional.isPresent()){
                System.out.println("Se envio el correo desde "+userAdminOptional.get().getEmail());
                System.out.println("Correo enviado a "+userOptional.get().getEmail()+
                        " Con placa de vehiculo "+vehicleOptional.get().getPlaca());
                System.out.println(emailRequest);
                throw new ResponseStatusException(HttpStatus.OK,"El Correo Ha Sido Enviado");
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El Correo al cual desea enviar no se encontro registrado, verifique e intente nuevamente");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La placa a enviar correo no se encuentra registrada");
    }

    public List<RegistrationVehicles> listRegistrationVehicles() {
        return registrationVehicleRepository.findAll();
    }
}
