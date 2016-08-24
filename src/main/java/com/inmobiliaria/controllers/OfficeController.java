/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.inmobiliaria.model.AjaxResponseBodyOffice;
import com.mkyong.web.jsonview.Views;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.inmobiliaria.entities.Office;

import com.inmobiliaria.services.OfficeService;
import java.util.List;

import javax.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//import org.springframework.ui.Model;
//cambiar printOffice() por printOffice(Model model) para pasar datos a la vista
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author ley
 */
@Controller
@RequestMapping("/office")
public class OfficeController {

    @Resource
    private OfficeService officeService;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OfficeController.class);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String printOffice(Model model) {
        Office office = new Office();
        model.addAttribute("office", office);
        return "addOffice";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveOffice(Model model, Office office) {
        if (!isValid(office)) {
            logger.debug("faltan datos");
        } else {
            try {

                this.officeService.insertar(office);
            } catch (Exception e) {

                logger.debug(e.getMessage());
            }
        }
        return printOffice(model);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listOffice(Model model) {
        List offices = this.officeService.getAllOffices();
        model.addAttribute("offices", offices);
        return "listOffice";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEditOffice(Model model) {
        List offices = this.officeService.getAllOffices();
        Office office = (Office) offices.get(0);
        //Office office = new Office();
        model.addAttribute("office", office);
        model.addAttribute("offices", offices);
        return "editOffice";
    }

    @ResponseBody
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/edit/editOffice", method = RequestMethod.POST)
    public AjaxResponseBodyOffice getSearchOfficeViaAjax(@RequestBody int office_id) {
        AjaxResponseBodyOffice result = new AjaxResponseBodyOffice();

        if (office_id > 0) {

            Office return_office = this.officeService.getOfficeById(office_id);
            logger.debug("get office address " + return_office.getAddress().getId());
            result.setCode("200");
            result.setMsg("Resultado ok");
            result.setResult(return_office);

        } else {
            result.setCode("400");
            result.setMsg("Please select an valid office!");
        }

        //AjaxResponseBodyOffice will be converted into json format and send back to client.
        return result;

    }

    @RequestMapping(value = "/edit", params="edit", method = RequestMethod.POST)
    public String editOffice(Model model, Office office) {
        this.officeService.updateOffice(office);
        return getEditOffice(model);
    }
    
    @RequestMapping(value = "/edit", params="delete", method = RequestMethod.POST)
    public String deleteOffice(Model model,Office office) {
        this.officeService.deleteOfficeById(office.getId());
       //return "redirect:/office/list";
       return getEditOffice(model);
    }

    /*@ResponseBody
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/addOffice", method = RequestMethod.POST)
    public AjaxResponseBodyOffice getSearchResultViaAjax(@RequestBody Office office) {
                logger.debug("post");
		AjaxResponseBodyOffice result = new AjaxResponseBodyOffice();
                
		if (isValid(office)) {
			
				result.setCode("200");
				result.setMsg("Resultado ok");
				result.setResult(office);
			 

		} else {
			result.setCode("400");
			result.setMsg("Some field is empty!");
		}

		//AjaxResponseBodyOffice will be converted into json format and send back to client.
		return result;

	}
     */
    private boolean isValid(Office office) {

        boolean valid = true;

        if (office == null) {
            valid = false;
        }

        if ((office.getName().length() == 0) || (office.getTelephone() == 0)) {
            valid = false;
        }

        return valid;
    }

    public OfficeService getOfficeService() {
        return officeService;
    }

    public void setOfficeService(OfficeService officeService) {
        this.officeService = officeService;
    }

}
