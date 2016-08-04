/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.entities;

/**
 *
 * @author ley
 */
public class Renter {
    private int id, telephone;
    private PropertyType prop_type;
    private String name;
    private float max_import;
    private Office office;
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMax_import() {
        return max_import;
    }

    public void setMax_import(float max_import) {
        this.max_import = max_import;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PropertyType getProp_type() {
        return prop_type;
    }

    public void setProp_type(PropertyType prop_type) {
        this.prop_type = prop_type;
    }
    
}
