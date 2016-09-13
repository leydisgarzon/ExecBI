/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.inmobiliaria.entities.Employee;
import com.inmobiliaria.model.AjaxResponseBodyEmployee;
import com.inmobiliaria.services.EmployeeService;
import com.inmobiliaria.services.OfficeService;
import com.inmobiliaria.util.Message;
import com.mkyong.web.jsonview.Views;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

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
    
    /*@RequestMapping(value="/add", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.insertEmployee(employee);
        return "employee/addEmployee";
    }*/
    
    @ResponseBody
    @JsonView(Views.Public.class)
    @RequestMapping(value="/add", method = RequestMethod.POST)
    //public AjaxResponseBodyEmployee addEmployee(@JsonView(Views.Public.class) @RequestBody Employee employee){
    public Message addEmployee(@RequestBody Employee employee){
        //Message result = null;
        Message result;
        try{
            result = new Message("Success insertion",Message.INFO);
            employeeService.insertEmployee(employee);
        } catch(Exception e){
            result = new Message("Error in the insertion: " + e.getMessage(),Message.ERROR);
            logger.debug("Error " + e.getMessage());
        }
        logger.debug(result.getMessage() + result.getType());
        //employeeService.insertEmployee(employee);
        return result;
    }
    
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String getEditEmployee(Model model){
        return "employee/editEmployee";
    }
}
