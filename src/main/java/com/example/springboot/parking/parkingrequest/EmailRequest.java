package com.example.springboot.parking.parkingrequest;

public class EmailRequest {

    private String email;
    private String placa;
    private String mensaje;

    public EmailRequest() {
    }

    public EmailRequest(String email, String placa, String mensaje) {
        this.email = email;
        this.placa = placa;
        this.mensaje = mensaje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "email='" + email + '\'' +
                ", placa='" + placa + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
