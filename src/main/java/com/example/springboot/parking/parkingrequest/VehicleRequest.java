package com.example.springboot.parking.parkingrequest;

import javax.validation.constraints.NotBlank;

public class VehicleRequest {
    @NotBlank(message = "se necesita la placa")
    public String placa;

    public VehicleRequest() {
    }

    public VehicleRequest(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "VehicleRequest{" +
                "placa='" + placa + '\'' +
                '}';
    }
}
