package com.example.springboot.parking.parkingentity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class RegistrationVehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String vehiclePlaca;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaIngreso;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaSalida;

    /*public RegistrationVehicles(String vehiclePlaca, LocalDateTime fechaIngreso) {
        this.vehiclePlaca = vehiclePlaca;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = LocalDateTime.now();
    }*/


    public RegistrationVehicles() {
    }

    public RegistrationVehicles(Vehicle vehicle) {
        this.vehiclePlaca = vehicle.getPlaca();
        this.fechaIngreso = vehicle.getFechaIngreso();
        this.fechaSalida = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehiclePlaca() {
        return vehiclePlaca;
    }

    public void setVehiclePlaca(String vehiclePlaca) {
        this.vehiclePlaca = vehiclePlaca;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "RegistrationVehicles{" +
                "id=" + id +
                ", vehiclePlaca='" + vehiclePlaca + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                '}';
    }
}
