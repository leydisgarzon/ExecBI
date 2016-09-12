/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;

import com.inmobiliaria.entities.Employee;
import com.inmobiliaria.entities.Manager;
import com.inmobiliaria.entities.Office;
import com.inmobiliaria.services.OfficeService;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ley
 */
@Controller
@RequestMapping(value="/manager")
public class ManagerController {
    private static final Logger logger = LoggerFactory.getLogger(OfficeController.class);
    @Resource
    private OfficeService officeService;
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String printManager(Model model) {
                List<Office> offices = officeService.getAllOffices();
                ArrayList<Employee> employees = new ArrayList();
                Manager manager = new Manager();
                String title = "Insert Manager";
                employees.add(new Employee(new Long(1), new Long(12548789), new Long(1756812705),"Leydis Garzon", "manager", Date.from(Instant.parse("1984-09-20T00:00:00Z")), Date.from(Instant.now()), 1100, offices.get(0), null, 0, null));
                employees.add(new Employee(new Long(2), new Long(12548789), new Long(1756812705),"Eduardo Alfonso", "worker", Date.from(Instant.parse("1985-11-11T00:00:00Z")), Date.from(Instant.now()), 1100, offices.get(0), null, 0, null));
                //office.setEmployees(employees);
                model.addAttribute("offices", offices);
                model.addAttribute("employees", employees);
                model.addAttribute("manager", manager);
                model.addAttribute("title", title);
                //logger.debug(office.getEmployees().get(0).toString());
		return "addManager";
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String saveMAnager(Model model, Office office){
        
        if(!isValid(office))
            logger.debug("faltan datos");
        else{
        try {
           
            logger.debug("Inserción Satisfactoria");
        } catch (Exception e) {
            logger.debug("Inserción Error");
        }
        }
        return printManager(model);
    }
    
    private boolean isValid(Office office) {

		boolean valid = true;

		if (office == null) {
			valid = false;
		}

		if ((office.getName().length()==0) || (office.getTelephone()== 0)) {
			valid = false;
		}

		return valid;
	}
}
