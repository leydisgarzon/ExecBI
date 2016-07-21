/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.entities;
import java.time.LocalDate;
/**
 *
 * @author ley
 */
public class Property {
    private int id, rooms;
    private float price;
    private LocalDate date_in;
    private PropertyType type;
    private Address address;
    private Office office;
    private Proprietor proprietor;
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate_in() {
        return date_in;
    }

    public void setDate_in(LocalDate date_in) {
        this.date_in = date_in;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Proprietor getProprietor() {
        return proprietor;
    }

    public void setProprietor(Proprietor proprietor) {
        this.proprietor = proprietor;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
