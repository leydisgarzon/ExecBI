/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ley
 */
public class Supervisor extends Employee {
   private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Supervisor(int id, int telephone, int dni, String name, String job, Date birthday, Date date_in, float salary, Office office, Address address, float speed_write, Familiar familiar) {
        super(id, telephone, dni, name, job, birthday, date_in, salary, office, address, speed_write, familiar);
    }


}
