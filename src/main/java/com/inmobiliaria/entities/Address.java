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
public class Address {
    
    private StringBuilder city, street, number;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public StringBuilder getCity() {
        return city;
    }

    public void setCity(StringBuilder city) {
        this.city = city;
    }

    public StringBuilder getStreet() {
        return street;
    }

    public void setStreet(StringBuilder street) {
        this.street = street;
    }

    public StringBuilder getNumber() {
        return number;
    }

    public void setNumber(StringBuilder number) {
        this.number = number;
    }
    
}
