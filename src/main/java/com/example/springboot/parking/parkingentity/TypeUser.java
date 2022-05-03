package com.example.springboot.parking.parkingentity;

import javax.persistence.*;

@Entity
@Table
public class TypeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameType;

    @Column(length = 255)
    private String description;

    public TypeUser() {
    }

    public TypeUser(String nameType, String description) {
        this.nameType = nameType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String name) {
        this.nameType = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypeUser{" +
                "id=" + id +
                ", nameType='" + nameType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
