/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;
import java.io.Console;
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
@RequestMapping("/inspection")
public class InspectionController {
    private static final Logger logger = LoggerFactory.getLogger(InspectionController.class);
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String addInspection(Model model){
        
        logger.debug("Metodo GET");
     return "addInspection";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addInspection(){
        logger.debug("Metodo POST");
     return "redirect:/addOffice";
    }
}
