/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//cambiar printOffice() por printOffice(Model model) para pasar datos a la vista
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ley
 */
@Controller
public class OfficeController {
    @RequestMapping(value="/addOffice")
    public String printOffice() {
		return "addOffice";
	}
}
