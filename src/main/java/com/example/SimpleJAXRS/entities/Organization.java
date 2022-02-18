package com.example.SimpleJAXRS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "coordinatex")
    private Float coordinatex;

    @Column(name = "coordinatey")
    private Long coordinatey;

    @Column(name = "creationdate")
    private java.time.LocalDate creationDate;

    @Column(name = "annualturnover")
    private Float annualTurnover;

    @Column(name = "organizationtype")
    private String type;

    @Column(name = "street")
    private String street;

    @Column(name = "town")
    private String town;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Float getAnnualTurnover() {
        return annualTurnover;
    }

    public Float getCoordinatex() {
        return coordinatex;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getCoordinatey() {
        return coordinatey;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnnualTurnover(Float annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public void setCoordinatex(Float coordinatex) {
        this.coordinatex = coordinatex;
    }

    public void setCoordinatey(Long coordinatey) {
        this.coordinatey = coordinatey;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setType(String type) {
        this.type = type;
    }
}
