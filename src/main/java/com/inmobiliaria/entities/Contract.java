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
public class Contract {
    private int id, month_duration;
    private float impor, deposit_import;
    private StringBuilder pay_type;
    private boolean deposit;
    private LocalDate date_in, date_out;  
    private Employee employee;
    private Renter renter;
    private Property property;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth_duration() {
        return month_duration;
    }

    public void setMonth_duration(int month_duration) {
        this.month_duration = month_duration;
    }

    public float getImpor() {
        return impor;
    }

    public void setImpor(float impor) {
        this.impor = impor;
    }

    public float getDeposit_import() {
        return deposit_import;
    }

    public void setDeposit_import(float deposit_import) {
        this.deposit_import = deposit_import;
    }

    public StringBuilder getPay_type() {
        return pay_type;
    }

    public void setPay_type(StringBuilder pay_type) {
        this.pay_type = pay_type;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    public LocalDate getDate_in() {
        return date_in;
    }

    public void setDate_in(LocalDate date_in) {
        this.date_in = date_in;
    }

    public LocalDate getDate_out() {
        return date_out;
    }

    public void setDate_out(LocalDate date_out) {
        this.date_out = date_out;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
    
}
