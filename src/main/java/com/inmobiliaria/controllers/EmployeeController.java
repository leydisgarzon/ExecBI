/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;

import com.inmobiliaria.entities.Employee;
import com.inmobiliaria.services.EmployeeService;
import com.inmobiliaria.services.OfficeService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ley
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;
    
    @Resource
    private OfficeService officeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddEmployee(Model model) {
        List offices = officeService.getAllOffices();
        Employee employee = new Employee();
        String title = "Add Employee";
        List supervisors = this.employeeService.getSupervisors(13);
        model.addAttribute("supervisors",supervisors);
        model.addAttribute("employee", employee);
        model.addAttribute("title",title);
        model.addAttribute("offices",offices);
        return "employee/addEmployee";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.insertEmployee(employee);
        return "employee/addEmployee";
    }
    
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String getEditEmployee(Model model){
        return "employee/editEmployee";
    }
}
