package com.example.springboot.parking.parkingentity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 6, unique = true)
    private String placa;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaIngreso;

    /*@Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaSalida;*/

    /*@ManyToOne(optional = false)
    private Zone idZona;*/



    public Vehicle() {
    }

    public Vehicle(String placa) {
        this.placa = placa;
        this.fechaIngreso = LocalDateTime.now();
    }

    /*public Vehicle(Long id, String placa) {
        this.id = id;
        this.placa = placa;
        this.fechaIngreso = LocalDateTime.now();
    }*/

    /*public Vehicle(String placa, LocalDateTime fechaIngreso, Zone idZona) {
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.idZona = idZona;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /*public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Zone getIdZona() {
        return idZona;
    }

    public void setIdZona(Zone idZona) {
        this.idZona = idZona;
    }*/

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", fechaIngreso=" + fechaIngreso + '\''+
                /*", fechaSalida=" + fechaSalida +*/
                /*", idZona=" + idZona +*/
                '}';
    }
}
