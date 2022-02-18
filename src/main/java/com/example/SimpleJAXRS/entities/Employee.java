package com.example.SimpleJAXRS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "orgid")
    private Long OrgId;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Long getOrgId() {
        return OrgId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrgId(Long orgId) {
        OrgId = orgId;
    }

    //public Employee() {}

    /*
    public Employee (int id, String name, Long orgid) {
        this.id = id;
        this.name = name;
        this.OrgId = orgid;
    }

     */
}

