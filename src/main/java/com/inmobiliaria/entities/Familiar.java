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
public class Familiar {
    private StringBuilder name, relation;
    private int telephone;
    private Address address;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringBuilder getName() {
        return name;
    }

    public void setName(StringBuilder name) {
        this.name = name;
    }

    public StringBuilder getRelation() {
        return relation;
    }

    public void setRelation(StringBuilder relation) {
        this.relation = relation;
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
    
}
