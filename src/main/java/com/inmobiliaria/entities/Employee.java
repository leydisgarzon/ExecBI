/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.entities;
import com.fasterxml.jackson.annotation.JsonView;
import com.mkyong.web.jsonview.Views;
import java.time.LocalDate;
/**
 *
 * @author ley
 */
public class Employee {
    @JsonView(Views.Public.class)
    protected int id, telephone,dni;
    @JsonView(Views.Public.class)
    protected String name, job;
    protected LocalDate birthday, date_in;
    protected float salary, speed_write;
    protected Office office;
    protected Familiar familiar;
    protected Supervisor supervisor;
   // private boolean isSupervisor;
    protected Address address;    

    public Employee(int id, int telephone, int dni, String name, String job, LocalDate birthday, LocalDate date_in, float salary, Office office, Address address, float speed_write,Familiar familiar) {
        this.id = id;
        this.telephone = telephone;
        this.dni = dni;
        this.name = name;
        this.job = job;
        this.birthday = birthday;
        this.date_in = date_in;
        this.salary = salary;
        this.speed_write = speed_write;
        this.office = office;
        this.familiar = familiar;
        //this.isSupervisor = supervisor;
        this.address = address;
    }
    
    public Employee(int id, int telephone, int dni, String name, String job, LocalDate birthday, LocalDate date_in, float salary, Office office, Address address, Familiar familiar) {
        this.id = id;
        this.telephone = telephone;
        this.dni = dni;
        this.name = name;
        this.job = job;
        this.birthday = birthday;
        this.date_in = date_in;
        this.salary = salary;
        this.speed_write = 0;
        this.office = office;
        //this.isSupervisor = supervisor;
        this.familiar = familiar;
        this.address = address;
    }

    public Employee() {
    }
    
    
    
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDate_in() {
        return date_in;
    }

    public void setDate_in(LocalDate date_in) {
        this.date_in = date_in;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSpeed_write() {
        return speed_write;
    }

    public void setSpeed_write(float speed_write) {
        this.speed_write = speed_write;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }


    public Supervisor getSupervisor() {
        return supervisor;
    }

    /*public boolean getSupervisor() {
    return isSupervisor;
    }
    public void setSupervisor(boolean supervisor) {
    this.isSupervisor = supervisor;
    }*/
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }
     
    @Override
    public String toString(){
        return "Employee [name=" + name + ", tel=" + telephone + "]";
    }
}
