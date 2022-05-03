package com.example.springboot.parking.parkingentity;

import com.example.springboot.parking.parkingrequest.RequestUser;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String cedula;
    private String direction;
    @NotBlank
    @Column(unique = true)
    private String email;
    @ManyToOne(optional = false)
    private TypeUser typeUserId;
    @NotBlank
    private String password;

    public User() {
    }

    /*public User(String name, String cedula, String direction, String email, TypeUser typeUserId, String password) {
        this.name = name;
        this.cedula = cedula;
        this.direction = direction;
        this.email = email;
        this.typeUserId = typeUserId;
        this.password = password;
    }*/

    public User(RequestUser request, TypeUser type) {
        this.name = request.getName();
        this.cedula = request.getCedula();
        this.direction = request.getDirection();
        this.email = request.getEmail();
        this.typeUserId = type;
        this.password = request.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TypeUser getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(TypeUser typeUserId) {
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direction='" + direction + '\'' +
                ", email='" + email + '\'' +
                ", typeUserId=" + typeUserId+ '\'' +
                ", password='" + password  +
                '}';
    }
}
