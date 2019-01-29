package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table (name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column (name = "name")
    private String name;
    @Column (name = "lastname")
    private String lastName;
    @Column (name = "active")
    private boolean active;
    //Nueva propiedad agregada
    @Column (name = "apellido")
    private String apellido;

    @OneToMany(mappedBy = "employee")
    private List<Address> addressList;

    public Employee() {
    }

    public Employee(String name, String lastName, boolean active) {
        this.name = name;
        this.lastName = lastName;
        this.active = active;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
