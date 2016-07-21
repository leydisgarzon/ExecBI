/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inmobiliaria.entities;
import java.util.ArrayList;

/**
 *
 * @author ley
 */
public class Office {
   private int id, fax, telephone;
   private Address address;
   private Manager manager;
   private ArrayList<Employee> employees;
   private ArrayList<Renter> renters;
   private ArrayList<Property> properties;
   private ArrayList<Supervisor> supervisors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }


    public ArrayList<Renter> getRenters() {
        return renters;
    }

    public void setRenters(ArrayList<Renter> renters) {
        this.renters = renters;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public ArrayList<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(ArrayList<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }
   
}
