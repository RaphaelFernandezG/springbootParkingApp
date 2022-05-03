package com.example.springboot.parking.parkingentity;

import javax.persistence.*;

@Entity
@Table
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameZone;
    private String section;

    /*public Zone() {
    }

    public Zone(String nameZone, String section) {
        this.nameZone = nameZone;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameZone() {
        return nameZone;
    }

    public void setNameZone(String nameZone) {
        this.nameZone = nameZone;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", nameZone='" + nameZone + '\'' +
                ", section='" + section + '\'' +
                '}';
    }*/
}
