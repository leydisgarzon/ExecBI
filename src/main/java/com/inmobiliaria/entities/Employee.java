/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.mkyong.web.jsonview.Views;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
//import java.time.LocalDate;

/**
 *
 * @author ley
 */
public class Employee {

    @JsonView(Views.Public.class)
    protected Long id, telephone, dni;
    @JsonView(Views.Public.class)
    protected String name, job;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date birthday;//, date_in;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date dateIn;
    protected float salary, speedWrite;
    protected Office office;
    protected List<Familiar> familiars;
    protected Supervisor supervisor;
    protected boolean isAdmin;
    protected Address address;

    public Employee(Long id, Long telephone, Long dni, String name, String job, Date birthday, Date dateIn, float salary, Office office, Address address, float speedWrite, List<Familiar> familiars) {
        this.id = id;
        this.telephone = telephone;
        this.dni = dni;
        this.name = name;
        this.job = job;
        this.birthday = birthday;
        this.dateIn = dateIn;
        this.salary = salary;
        this.speedWrite = speedWrite;
        this.office = office;
        this.familiars = familiars;
        this.isAdmin = true;
        this.address = address;
    }

    public Employee(Long id, Long telephone, Long dni, String name, String job, Date birthday, Date dateIn, float salary, Office office, Address address, List<Familiar> familiars) {
        this.id = id;
        this.telephone = telephone;
        this.dni = dni;
        this.name = name;
        this.job = job;
        this.birthday = birthday;
        this.dateIn = dateIn;
        this.salary = salary;
        this.speedWrite = 0;
        this.office = office;
        this.isAdmin = false;
        this.familiars = familiars;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSpeedWrite() {
        return speedWrite;
    }

    public void setSpeedWrite(float speedWrite) {
        this.speedWrite = speedWrite;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Familiar> getFamiliars() {
        return familiars;
    }

    public void setFamiliars(List<Familiar> familiars) {
        this.familiars = familiars;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", tel=" + telephone +  ", sal=" + salary + "]";
    }
}
