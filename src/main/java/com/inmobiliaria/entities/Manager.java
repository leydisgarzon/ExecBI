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
public class Manager extends Employee{
    private LocalDate date_boss;
    private float bonus, car_expense;

    public Manager(LocalDate date_boss, float bonus, float car_expense, int id, int telephone, int dni, StringBuilder name, StringBuilder job, LocalDate birthday, LocalDate date_in, float salary, Office office, Address address, float speed_write, Familiar familiar) {
        super(id, telephone, dni, name, job, birthday, date_in, salary, office, address, speed_write, familiar);
        this.date_boss = date_boss;
        this.bonus = bonus;
        this.car_expense = car_expense;
    }


    public LocalDate getDate_boss() {
        return date_boss;
    }

    public void setDate_boss(LocalDate date_boss) {
        this.date_boss = date_boss;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getCar_expense() {
        return car_expense;
    }

    public void setCar_expense(float car_expense) {
        this.car_expense = car_expense;
    }

    
}
