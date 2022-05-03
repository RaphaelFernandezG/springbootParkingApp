package com.example.springboot.parking.parkingrequest;

import com.example.springboot.parking.parkingentity.TypeUser;


public class RequestUser {

    private String name;
    private String cedula;
    private String direction;
    private String email;
    private Long typeUserId;
    private String password;

    public RequestUser() {
    }

    public RequestUser(String name, String cedula, String direction, String email, Long typeUserId, String password) {
        this.name = name;
        this.cedula = cedula;
        this.direction = direction;
        this.email = email;
        this.typeUserId = typeUserId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(Long typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestUser{" +
                "name='" + name + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direction='" + direction + '\'' +
                ", email='" + email + '\'' +
                ", typeUserId=" + typeUserId+ '\'' +
                ", password='" + password  +
                '}';
    }
}
